package com.yeyu.controller;

import com.yeyu.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @Autowired
    HelloService helloService;


    @ResponseBody
    @RequestMapping("hello")
    public String hello() {
        String hello = helloService.sayHello("tomcat..");
        return hello;
    }

    //访问的是/WEB-INF/views/success.jsp
    @RequestMapping("/success")
    public String success() {
        return "success";
    }

}
