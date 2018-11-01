package com.example.springCloudService.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 86923 on 2018/10/17.
 */
@RestController
public class HelloController {
    @Value("${server.port}")
    private int serverPort;

    @RequestMapping("/print")
    public String serverPortPrint(@RequestParam(value = "name",defaultValue = "oscar") String name){

        return "Hi"+ name +" ,i am from port："+serverPort;
    }
}
