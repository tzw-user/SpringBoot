package com.example.firstappdemo.service;

import com.example.firstappdemo.domain.WeatherResponse;

/**
 * Weather Data Service
 * Created by 谭志为 on 2018/9/7.
 */

public interface WeatherDataService {

    /**
     * 根据城市id获取天气数据
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityid(String cityId);

    /**
     * 根据城市名称获取天气数据
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName );
}
