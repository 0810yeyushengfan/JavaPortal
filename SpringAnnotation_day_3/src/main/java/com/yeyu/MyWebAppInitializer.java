package com.yeyu;

import com.yeyu.config.AppConfig;
import com.yeyu.config.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//web容器启动的时候创建对象，调用方法来初始化容器以及前端控制器
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //获取根容器的配置类(即Spring的配置文件)，作为父容器
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    //获取web容器的配置类(SpringMVC配置文件)，作为子容器；
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    //获取DispatcherServlet的映射信息
    //1./:拦截所有请求(包括静态资源(xx.js,xx.png))，但是不包括*.jsp
    //2./*:拦截所有请求，连*.jsp页面都拦截，但是因为jsp页面是tomcat的jsp引擎解析的，不能被DispatcherServlet拦截，所以不能用/*
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
