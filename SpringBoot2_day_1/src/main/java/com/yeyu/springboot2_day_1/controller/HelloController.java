package com.yeyu.springboot2_day_1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class HelloController {
    @Autowired
    private Environment environment;
    @GetMapping
    public String getById() {
        System.out.println(environment.getProperty("lesson"));
        System.out.println(environment.getProperty("enterprise.name"));
        System.out.println(environment.getProperty("enterprise.subject[0]"));

        return "springboot is running...";
    }
}

