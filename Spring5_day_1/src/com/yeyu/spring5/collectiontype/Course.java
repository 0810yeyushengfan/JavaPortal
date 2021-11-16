package com.yeyu.spring5.collectiontype;

//课程类
public class Course {
    private String name; //课程名称

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
