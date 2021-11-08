package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*
什么是Servlet?
1、Servlet是JavaEE规范之一，规范就是接口
2、Servlet是JavaWeb三大组件之一。三大组件分别是：Servlet程序、Filter过滤器、Listener监听器。
3、Servlet是运行在服务器上的一个java小程序，它可以接收客户端发送过来的请求，并响应数据给客户端。
 */

/*
手动实现Servlet程序
1.编写一个类去实现Servlet接口
2.实现service()方法，处理请求，并响应数据
3.到web.xml中去配置servlet程序的访问地址
 */
/*
Servlet程序的生命周期:
1.执行Servlet构造器方法
2.执行init初始化方法
第1.2步是在第一次访问Servlet程序地址的时候创建Servlet时执行
3.执行service方法
第3步每次访问Servlet程序地址时都会执行
4.执行destroy销毁方法
第4步在当前web工程停止时执行
 */

/*
ServletConfig类:
1.从类名上来看，就知道是Servlet程序的配置信息类。
2.Servlet程序和ServletConfig对象都是由Tomcat负责创建，我们负责使用。
3.Servlet程序默认是第一次访问的时候创建，ServletConfig是每个Servlet程序创建时，会在init()中传入一个ServletConfig对象，并创建一个对应的ServletConfig属性将其保存起来

ServletConfig类的三大作用:
1.可以获取Servlet程序的别名即<servlet-name>的值
2.获取初始化参数即<init-param>的值
3.获取ServletContext对象
 */

public class HelloServlet implements Servlet {

    public HelloServlet(){
        System.out.println("第一步:执行Servlet构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("第二步:执行init初始化方法");
        // 1、可以获取 Servlet 程序的别名 servlet-name 的值
        System.out.println("HelloServlet程序的别名是:" + servletConfig.getServletName());
        // 2、获取初始化参数 init-param
         System.out.println("初始化参数username的值是:" + servletConfig.getInitParameter("username"));
         System.out.println("初始化参数url的值是:" + servletConfig.getInitParameter("url"));
        // 3、获取 ServletContext 对象
        System.out.println(servletConfig.getServletContext());

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    //service()方法是专门用来处理请求和响应
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("helloServlet被访问了!");
        System.out.println("第三步:执行service方法");
        //HttpServletRequest是ServletRequest的子类，只有它有getMethod()方法
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        //获取请求的方式
        String method=httpServletRequest.getMethod();
        if("GET".equals(method)){
            doGet();
        }else if("POST".equals(method)){
            doPost();
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("第四步:执行destroy销毁方法");
    }

    public void doGet(){
        System.out.println("HelloServlet接收了get请求");
    }

    public void doPost(){
        System.out.println("HelloServlet接收了post请求");
    }
}
