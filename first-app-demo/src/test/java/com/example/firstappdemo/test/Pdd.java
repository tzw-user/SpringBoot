package com.example.firstappdemo.test;

/**
 * Created by 86923 on 2018/10/10.
 */
public class Pdd {
    /**
     * 懒汉模式
     */
    private static Pdd pdd=null;

    private Pdd(){

    }

    public static Pdd getPdd(){
        if (pdd == null){
            pdd=new Pdd();
        }
        return pdd;
    }

}
