package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
一般在实际项目开发中，都是使用继承HttpServlet类的方式去实现Servlet程序。
1.编写一个类去继承HttpServlet类
2.根据业务需要重写doGet()或doPost()方法
3.到web.xml中配置当前Servlet程序的访问地址
 */

/*
ServletContext类:
什么是ServletContext?
1.ServletContext是一个接口，它表示Servlet的上下文对象
2.一个web工程，只有一个ServletContext对象实例。
3.ServletContext对象是一个域对象。
什么是域对象?
域对象，是可以像Map一样存取数据的对象，叫域对象。这里的域指的是存取数据的操作范围，即整个web工程。
对象类型    存数据            取数据           删除数据
Map        put()           get()           remove()
域对象      setAttribute()  getAttribute()  removeAttribute();
4.ServletContext是在web工程部署启动的时候创建。在web工程停止的时候销毁。

ServletContext类的四个作用:
1.获取web.xml中配置的上下文参数即<context-param>
2.获取当前的工程路径，格式:/工程路径
3.获取工程部署后在服务器硬盘上的绝对路径
4.像Map一样存取数据
 */
public class HelloServlet2 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        //这里一定要调用父类(即GenericServlet)类的init()方法，才能将ServletConfig保存下来
        super.init(config);
        System.out.println("重写了init方法，做了一些准备活动");
    }

    //在get请求的时候调用
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletConfig().getServletContext();
        //1.获取web.xml中配置的上下文参数即<context-param>
        String username = context.getInitParameter("username");
        System.out.println("context-param 参数 username 的值是:" + username);
        System.out.println("context-param 参数 password 的值是:" + context.getInitParameter("password"));
        //2.获取当前的工程路径，格式:/工程路径
        System.out.println( "当前工程路径:" + context.getContextPath() );
        //3.获取工程部署后在服务器硬盘上的绝对路径
        //斜杠(/)被服务器解析地址为:http://ip:port/工程名/映射到IDEA代码的web目录
        System.out.println("工程部署的路径是:" + context.getRealPath("/"));
        //4.像Map一样存取数据
        // 获取ServletContext对象的另一种方法
        ServletContext context1 = getServletContext();
        System.out.println(context1);
        System.out.println("保存之前:HelloServlet2获取key1的值是:"+ context1.getAttribute("key1"));
        context.setAttribute("key1", "value1");
        System.out.println("保存之后:HelloServlet2中获取域数据key1的值是:"+ context1.getAttribute("key1"));

        System.out.println("HelloServlet2的doGet方法");


    }

    //在post请求的时候调用
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2的doPost方法");
    }
}
