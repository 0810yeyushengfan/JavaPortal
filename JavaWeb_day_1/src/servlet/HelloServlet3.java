package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/*
Servlet类的继承体系:
1.javax.servlet包下的interface接口Servlet:只是负责定义Servlet程序的访问规范
2.javax.servlet包下的Class类GenericServlet:实现了Servlet接口，对接口中定义的方法做了很多空实现，
  并持有一个ServletConfig类的引用，对ServletConfig的使用定义了一些方法
3.javax.servlet.http包下的Class类HttpServlet:实现了service()方法，主要实现了请求的分发处理，
  即把请求按照GET和POST进行分类，GET请求进入到doGet()方法中进行处理，POST请求进入doPost()请求中进行处理，
  但是处理的方式只是负责抛出一个说不支持GET/POST请求的异常
4.自定义的Servlet程序:我们只需要根据自己的业务需要去重写doGet()方法或者doPost()方法即可
 */
public class HelloServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        System.out.println(context);
        System.out.println("HelloServlet3中获取域数据key1的值是:" + context.getAttribute("key1"));
        System.out.println("HelloServlet3的doGet方法");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet3的doPost方法");

    }
}
