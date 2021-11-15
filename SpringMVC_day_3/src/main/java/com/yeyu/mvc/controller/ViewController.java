package com.yeyu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
SpringMVC的视图:
1.SpringMVC中的视图是View接口，视图的作用渲染数据，将模型Model中的数据展示给用户
2.SpringMVC视图的种类很多，默认有转发视图(InternalResourceView)和重定向视图(RedirectView)
3.当工程引入jstl的依赖，转发视图会自动转换为JstlView
4.若使用的视图技术为Thymeleaf，在SpringMVC的配置文件中配置了Thymeleaf的视图解析器，由此视图解析器解析之后所得到的是ThymeleafView
 */
@Controller
public class ViewController {
    //1.ThymeleafView:
    //当控制器方法中所设置的视图名称没有任何前缀时，此时的视图名称会被SpringMVC配置文件中所配置的视图解析器解析，
    //视图名称拼接视图前缀和视图后缀所得到的最终路径，会通过转发的方式实现跳转
    @RequestMapping("/testThymeleafView")
    public String testThymeleafView() {
        return "success";
    }

    /*
    2.转发视图
    2.1.SpringMVC中默认的转发视图是InternalResourceView
    2.2.SpringMVC中创建转发视图的情况:
    当控制器方法中所设置的视图名称以"forward:"为前缀时，创建InternalResourceView视图，此时的视图名称不会被
    SpringMVC配置文件中所配置的视图解析器解析，而是会将前缀"forward:"去掉，剩余部分作为最终路径通过转发的方式实现跳转，
    请求转发必须要以斜杠打头，/(斜杠)表示地址为:http://ip:port/工程名/,即映射到IDEA代码的webapp目录
    此时在转发的时候，会再次匹配这个最终路径，并创建第二个视图也就是会被SpringMVC配置文件中所配置的视图解析器解析的视图，
    在这里是ThymeleafView，然后通过视图名称拼接视图前缀和视图后缀所得到的最终路径，实现跳转
     */
    @RequestMapping("testForward")
    public String testForward() {
        return "forward:/testThymeleafView";
    }

    /*
    3.重定向视图:
    3.1.SpringMVC中默认的重定向视图是RedirectView
    3.2.SpringMVC中创建重定向视图的情况:
    当控制器方法中所设置的视图名称以"redirect:"为前缀时，创建RedirectView视图，此时的视图名称不会被
    SpringMVC配置文件中所配置的视图解析器解析，而是会将前缀"redirect:"去掉，然后会判断剩余部分是否以/开头，
    若是则会自动拼接上下文路径(重定向必须要写出全部的路径，但是因为解析的时候如果以/开头就会自动加上http://ip:port/工程名/，
    所以不需要手动写出)，把这个路径作为最终路径通过重定向的方式实现跳转，此时在转发的时候，会再次匹配这个最终路径，
    并创建第二个视图也就是会被SpringMVC配置文件中所配置的视图解析器解析的视图，在这里是ThymeleafView，
    然后通过视图名称拼接视图前缀和视图后缀所得到的最终路径，实现跳转。
    正是因为能够进行第二次转发，这里的重定向才能访问到被服务器保护的WEB-INF目录
     */
    @RequestMapping("testRedirect")
    public String testRedirect() {
        return "redirect:/testThymeleafView";
    }
}
