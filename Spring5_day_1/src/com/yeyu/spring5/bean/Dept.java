package com.yeyu.spring5.bean;

//部门类
public class Dept {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + name + '\'' +
                '}';
    }
}
