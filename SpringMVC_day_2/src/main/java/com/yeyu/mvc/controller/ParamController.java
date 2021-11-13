package com.yeyu.mvc.controller;

import com.yeyu.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

//SpringMVC获取请求参数
@Controller
public class ParamController {

    /*
    1.通过ServletAPI获取:
    将HttpServletRequest作为控制器方法的形参，此时HttpServletRequest类型的参数表示封装了当前请求的请求报文的对象
     */
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username" + username + ",password" + password);
        return "success";
    }

    /*
    2.通过控制器方法的形参获取请求参数
    2.1.在控制器方法的形参位置，设置和请求参数同名的形参，当浏览器发送请求，匹配到请求映射时，在DispatcherServlet中就会将请求参数赋值给相应的形参
    2.2.注:
    2.2.1.若请求所传输的请求参数中有多个同名的请求参数，此时可以在控制器方法的形参中设置字符串数组或者字符串类型的形参接收此请求参数
    2.2.2.若使用字符串数组类型的形参，此参数的数组中包含了每一个数据
    2.2.3.若使用字符串类型的形参，此参数的值为每个数据中间使用逗号拼接的结果
     */
    /*
    3.@RequestParam:
    3.1.@RequestParam是将请求参数和控制器方法的形参创建映射关系
    3.2.@RequestParam注解一共有三个属性:
    3.2.1.value:指定为形参赋值的请求参数的参数名
    3.2.2.required:设置是否必须传输此请求参数，默认值为true，若设置为true时，则当前请求必须传输value所指定的请求参数，
    若没有传输该请求参数，且没有设置defaultValue属性，则页面报错400：Required String parameter 'xxx' is not
    present，若设置为false，则当前请求不是必须传输value所指定的请求参数，若没有传输，则注解所标识的形参的值为null
    3.2.3.defaultValue:不管required属性值为true或false，当value所指定的请求参数没有传输或传输的值为""(空字符串)时，
    则使用默认值为形参赋值(可以这样理解，首先为参数赋值成defaultValue，然后再判定required是否符合要求，最后再把参数赋值成传过来的值)
    4.@RequestHeader:
    4.1.RequestHeader是将请求头信息和控制器方法的形参创建映射关系
    4.2.@RequestHeader注解一共有三个属性:value、required、defaultValue，用法同@RequestParam
    5.@CookieValue:
    5.1.@CookieValue是将cookie数据和控制器方法的形参创建映射关系
    5.2.@CookieValue注解一共有三个属性:value、required、defaultValue，用法同@RequestParam
     */
    @RequestMapping("/testParam")
    public String testParam(
            @RequestParam(value = "user_name", required = false, defaultValue = "hehe") String username,
            String password, String[] hobby,
            @RequestHeader(value = "Host", required = true, defaultValue = "haha") String host,
            @CookieValue("JSESSIONID") String JSESSIONID
    ) {
        System.out.println("username:" + username + ",password:" + password + ",hobby:" + Arrays.asList(hobby) + ",host:" + host + ",JSESSIONID" + JSESSIONID);
        return "success";
    }

    /*
    6.通过POJO获取请求参数:
    可以在控制器方法的形参位置设置一个实体类类型的形参，此时若浏览器传输的请求参数的参数名和实体类中的属性名一致，
    那么请求参数就会为此属性赋值
     */
    @RequestMapping("/testBean")
    public String testBean(User user) {
        System.out.println(user);
        return "success";
    }


}
