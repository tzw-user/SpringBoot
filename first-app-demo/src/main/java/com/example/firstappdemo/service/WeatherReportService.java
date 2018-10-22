package com.example.firstappdemo.service;

import com.example.firstappdemo.domain.Weather;

/**
 * Created by 谭志为 on 2018/9/7.
 */
public interface WeatherReportService {

    Weather getDataByCityId(String cityId);

    Weather getDataByCityName(String CityName);
}
