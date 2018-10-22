package com.example.firstappdemo.controller;

import com.example.firstappdemo.service.WeatherDataService;
import com.example.firstappdemo.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Weather Report Controller
 * Created by 谭志为 on 2018/9/7.
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping(value = "/cityId/{cityid}")
    public ModelAndView getReportByCityid(@PathVariable String cityid, Model model){
        model.addAttribute("title","老谭的天气预报");
        model.addAttribute("cityId",cityid);
        model.addAttribute("report",weatherReportService.getDataByCityId(cityid));
      return new ModelAndView("weather/report","reportModel",model);
    }

    @GetMapping(value = "/cityName/{cityName}")
    public ModelAndView getDataByCityName(@PathVariable String cityName, Model model){
        model.addAttribute("title","老谭的天气预报");
        model.addAttribute("cityId",cityName);
        model.addAttribute("report",weatherReportService.getDataByCityName(cityName));
        return new ModelAndView("weather/report","reportModel",model);
    }


}
