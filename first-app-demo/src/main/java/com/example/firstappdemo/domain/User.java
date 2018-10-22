package com.example.firstappdemo.domain;

/**
 * 用户模型
 * Created by 谭志为 on 2018/8/31.
 */
public class User {
    /**
     * 用户编号
     */

   private int id;

    /**
     * 用户名称
     */
   private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
