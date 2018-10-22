package com.example.firstappdemo.serviceImpl;

import com.example.firstappdemo.domain.WeatherResponse;
import com.example.firstappdemo.service.WeatherDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Weather Data Service Impl
 * Created by 谭志为 on 2018/9/7.
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private final static Logger logger= LoggerFactory.getLogger(WeatherDataServiceImpl.class);
    private static final String WEATHER_URI ="http://wthrcdn.etouch.cn/weather_mini?";
    //气象局一般三十分钟更新一次天气数据
    private static final long TIME_OUT=1800L;

    @Autowired
     RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 根据城市id获取天气数据
     * @param cityId
     * @return
     */
    public WeatherResponse getDataByCityid(String cityId) {
        String uri=WEATHER_URI+"citykey="+cityId;

        return this.doGetWeather(uri);
    }

    /**
     * 根据城市名称获取天气数据
     * @param cityName
     * @return
     */
    public WeatherResponse getDataByCityName(String cityName) {
        String uri=WEATHER_URI+"city="+cityName;

        return this.doGetWeather(uri);
    }


    /**
     * 提取公共代码
     * @param uri
     * @return
     */
    public  WeatherResponse doGetWeather(String uri) {
        String strBoby=null;
        WeatherResponse resp=null;
        ObjectMapper objectMapper=new ObjectMapper();
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        /**
         * 先查缓存，缓存有的取缓存中的数据
         * 由于每个城市的uri是不一样的，所以使用uri作为key;
         */
        if(redisTemplate.hasKey(uri)){
            logger.info("redis has data");
            strBoby=opsForValue.get(uri);
        }else {
            //缓存没有的，再调用服务接口来获取
            logger.info("redis don't has data");
            ResponseEntity<String> forEntity = restTemplate.getForEntity(uri,String.class);
            /**
             * 反序列化时,遇到未知属性(那些没有对应的属性来映射的属性,并且没有任何setter或handler来处理这样的属性)时是否引起结果失败
             * (通过抛JsonMappingException异常).此项设置只对那些已经尝试过所有的处理方法之后并且属性还是未处理
             * (这里未处理的意思是:最终还是没有一个对应的类属性与此属性进行映射)的未知属性才有影响.
             * 此功能默认是启用的(意味着,如果遇到未知属性时会抛一个JsonMappingException)
             * objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
             */
            //通过判断状态码判断是否请求成功
            if (forEntity.getStatusCodeValue()==200){
                strBoby=forEntity.getBody();
            }
            //数据写入缓存
            opsForValue.set(uri,strBoby,TIME_OUT,TimeUnit.SECONDS);
        }

        try {

            resp=objectMapper.readValue(strBoby,WeatherResponse.class);

        } catch (IOException e) {
            //e.printStackTrace();
            logger.error("Error！",e);
        }

        return resp;
    }
}
