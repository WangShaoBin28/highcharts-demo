package com.app.entity;

/**
 * @Package com.app.entity
 * @ClassName Demo
 * @Author wangshaobin
 * @Date 2018/10/22 10:33
 * @Version 1.0
 * @Description:
 **/
public class Demo {
    private String name;
    private Integer y;

    public Demo(String name, Integer y) {
        this.name = name;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
