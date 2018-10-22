package com.example.firstappdemo.serviceImpl;

import com.example.firstappdemo.domain.Weather;
import com.example.firstappdemo.domain.WeatherResponse;
import com.example.firstappdemo.service.WeatherDataService;
import com.example.firstappdemo.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 谭志为 on 2018/9/7.
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse dataByCityid = weatherDataService.getDataByCityid(cityId);

        return dataByCityid.getData();
    }

    @Override
    public Weather getDataByCityName(String cityName) {
        WeatherResponse dataByCityid = weatherDataService.getDataByCityName(cityName);

        return dataByCityid.getData();
    }
}
