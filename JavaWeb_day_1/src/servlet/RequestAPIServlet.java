package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/*
HttpServletRequest类:
1.HttpServletRequest类有什么作用:
每次只要有请求进入Tomcat服务器，Tomcat服务器就会把请求过来的HTTP协议信息解析好封装到Request对象中。然后传递到service方法
(或者分发成doGet()和doPost()方法)中给我们使用。我们可以通过方法中的HttpServletRequest对象，获取到所有请求的信息。
2.HttpServletRequest类的常用方法:
2.1.getRequestURI():获取请求的资源路径
2.2.getRequestURL():获取请求的统一资源定位符(绝对路径)
2.3.getRemoteHost():获取客户端的ip地址
2.4.getHeader():获取请求头
2.5.getParameter():获取请求的参数
2.6.getParameterValues():获取请求的参数(参数有多个值的时候使用)
2.7.getMethod():获取请求的方式(GET或POST)
2.8.setAttribute(key, value):设置域数据
2.9.getAttribute(key):获取域数据
2.10.getRequestDispatcher():获取请求转发对象
 */
public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getRequestURI():获取请求的资源路径
        System.out.println("URI是:" + request.getRequestURI());
        //getRequestURL():获取请求的统一资源定位符(绝对路径)
        System.out.println("URL是:" + request.getRequestURL());
        //getRemoteHost():获取客户端的ip地址
        //在IDEA中使用localhost访问时，得到的客户端ip地址是127.0.0.1
        //在IDEA中使用 27.0.0.1访问时，得到的客户端ip地址是127.0.0.1
        //在IDEA中，使用真实ip访问时，得到的客户端ip地址是真实的客户端ip地址
        System.out.println("客户端ip地址是:" + request.getRemoteHost());
        //getHeader():获取请求头
        System.out.println("请求头User-Agent是:" + request.getHeader("User-Agent"));
        //getMethod():获取请求的方式(GET或POST)
        System.out.println("请求的方式是:" + request.getMethod());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
