package com.yeyu.spring5.bean;

//员工类
public class Emp {
    private String name;
    private String gender;
    //员工属于某一个部门，使用对象形式表示
    private Dept dept;

    //生成dept的get方法
    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void add() {
        System.out.println(name + "::" + gender + "::" + dept);
    }
}
