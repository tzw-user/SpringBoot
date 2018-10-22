package com.example.firstappdemo.controller;

import com.example.firstappdemo.domain.WeatherResponse;
import com.example.firstappdemo.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 谭志为 on 2018/9/7.
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping(value = "/cityId/{cityid}",produces = "text/plain;charset=UTF-8")
    public WeatherResponse getDataByCityid(@PathVariable String cityid){


        return weatherDataService.getDataByCityid(cityid);
    }

    @GetMapping(value = "/cityName/{cityName}")
    public WeatherResponse getDataByCityName(@PathVariable String cityName){


        return weatherDataService.getDataByCityName(cityName);
    }

}
