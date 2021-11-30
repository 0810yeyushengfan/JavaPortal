package com.yeyu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//监听项目的启动和停止
public class UserListener implements ServletContextListener {

    //监听ServletContext的销毁
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("UserListener...contextDestroyed...");
    }

    //监听ServletContext的初始化
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        //在这里获取到servletContext对象之后也能注册组件
        //处于安全考虑，只有在项目运行之前才能通过servletContext对象给容器中注册组件
        //只有在ServletContextListener的contextInitialize()方法和ServletContainerInitializer的onStartup()
        //方法中才能在项目运行之前获取到servletContext对象，因此只有通过这两个方法才能使用ServletContext注册组件
        ServletContext servletContext = arg0.getServletContext();
        System.out.println("UserListener...contextInitialized...");
    }

}
