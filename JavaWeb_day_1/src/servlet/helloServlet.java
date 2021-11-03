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
public class helloServlet implements Servlet {

    public helloServlet(){
        System.out.println("第一步:执行Servlet构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("第二步:执行init初始化方法");

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    //service()方法是专门用来处理请求和响应
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("helloServlet 被访问了!");
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
        System.out.println("get请求");
    }

    public void doPost(){
        System.out.println("post请求");
    }
}
