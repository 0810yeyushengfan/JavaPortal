package com.yeyu.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
流程总结:
浏览器发送请求，若请求地址符合前端控制器的url-pattern，该请求就会被前端控制器DispatcherServlet处理。前端控制器会读取
SpringMVC的核心配置文件，通过扫描组件找到控制器，将请求地址和控制器中@RequestMapping注解的value属性值进行匹配，若匹配
成功，该注解所标识的控制器方法就是处理请求的方法。处理请求的方法需要返回一个字符串类型的视图名称，该视图名称会被视图解析器解
析，加上前缀和后缀组成视图的路径，通过Thymeleaf对视图进行渲染，最终转发到视图所对应页面
 */
@Controller
public class helloController {
    //@RequestMapping注解:处理请求和控制器方法之间的映射关系
    //@RequestMapping注解的value属性可以通过请求地址匹配请求
    ///(斜杠)表示的当前工程的上下文路径即localhost:8080/SpringMVC_day_1/
    @RequestMapping( value ="/")
    public String index(){
        //返回视图名称
        return "index";
    }

    //当注解中只有一个属性value时，可以将value省略，只留下赋给value的值
    @RequestMapping( "/target")
    public String toTarget(){
        //返回视图名称
        return "target";
    }
}
