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
    public String testThymeleafView(){
        return "success";
    }

    @RequestMapping("testForward")
    public String testForward(){
        return "forward:/testThymeleafView";
    }

    @RequestMapping("testRedirect")
    public String testRedirect(){
        return "redirect:/testThymeleafView";
    }
}
