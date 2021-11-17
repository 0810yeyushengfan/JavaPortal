package com.yeyu.springboot2_day_1.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class HelloController {

    @GetMapping
    public String index(){
        System.out.println("hello");
        return "hello springboot2";
    }
}
