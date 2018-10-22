package com.example.firstappdemo.test;

/**
 * Created by 86923 on 2018/10/10.
 */
public class App {
    /**
     * 饿汉模式
     */
    private static final App app=new App();

    private App(){

    }

    public static App getApp(){
        return app;
    }
}
