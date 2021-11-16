package com.yeyu.spring5.bean;

public class User {

    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public User() {
    }

    public void add() {
        System.out.println("add......");
    }
}
