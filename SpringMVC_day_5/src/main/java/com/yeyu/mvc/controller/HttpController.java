package com.yeyu.mvc.controller;


import com.yeyu.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
6.@RestController注解:
@RestController注解是springMVC提供的一个复合注解，标识在控制器的类上，就相当于为类添加了@Controller注解，
并且为其中的每个方法添加了@ResponseBody注解，因为在方法中添加@ResponseBody注解的行为很常见，所以出现了这个注解能批量添加
 */
@Controller
public class HttpController {

    //1.@RequestBody:
    //@RequestBody可以获取请求体，需要在控制器方法设置一个形参，使用@RequestBody进行标识，
    //当前请求的请求体就会为当前注解所标识的形参赋值
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println("requestBody:" + requestBody);
        return "success";
    }

    //2.RequestEntity:
    //RequestEntity封装请求报文的一种类型，需要在控制器方法的形参中设置该类型的形参，当前请求的请求报文就会赋值给该形参，
    //可以通过getHeaders()获取请求头信息，通过getBody()获取请求体信息
    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity) {
        System.out.println("请求头:" + requestEntity.getHeaders());
        System.out.println("请求体:" + requestEntity.getBody());
        return "success";
    }

    //使用ServletAPI向响应体response中添加信息
    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello,response");
    }

    //3.@ResponseBody
    //@ResponseBody用于标识一个控制器方法，可以将该方法的返回值直接作为响应报文的响应体响应到浏览器
    @RequestMapping(value = "/testResponseBody", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String testResponseBody() {
        return "成功!";
    }

    //4.SpringMVC处理json
    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser() {
        //将Java对象直接作为控制器方法的返回值返回，就会自动转换为Json格式的字符串
        return new User(1001, "yeyushengfan", "123456", 23, "男");
    }

    //5.SpringMVC处理ajax
    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username, String password) {
        System.out.println(username + "," + password);
        return "hello,axios";
    }
}
