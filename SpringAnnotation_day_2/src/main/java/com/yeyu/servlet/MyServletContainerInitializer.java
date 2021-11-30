package com.yeyu.servlet;

import com.yeyu.service.HelloService;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

//容器启动的时候会将@HandlesTypes注解的value属性中指定的这个类型的子类(实现类，子接口等)传递到onStartup()方法的第一个参数中
@HandlesTypes(value = HelloService.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {
    /*
     容器启动的时候，会自动调用onStartup()方法
     onStartup()方法的参数:
     1.set:@HandlesTypes注解的value属性中指定的这个类型的子类(实现类，子接口等)
     2.servletContext:当前Web应用的ServletContext(一个Web应用对应一个ServletContext)
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("@HandlesTypes注解的value属性中指定的这个类型的子类:");
        for (Class<?> clazz : set) {
            System.out.println(clazz);
        }
        //使用ServletContext注册Web组件(Servlet、Filter、Listener)
        //注册Servlet组件，需要用到ServletRegistration
        //第一个参数是Servlet组件的id，第二个参数是需要注册的Servlet组件
        ServletRegistration.Dynamic servlet = servletContext.addServlet("userServlet", new UserServlet());
        //配置注册的servlet的映射信息
        servlet.addMapping("/user");
        //注册Listener
        servletContext.addListener(new UserListener());
        //注册Filter组件，需要用到FilterRegistration
        //第一个参数是Filter组件的id，第二个参数是需要注册的Filter组件
        FilterRegistration.Dynamic filter = servletContext.addFilter("userFilter", new UserFilter());
        //配置Filter的映射信息
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }
}
