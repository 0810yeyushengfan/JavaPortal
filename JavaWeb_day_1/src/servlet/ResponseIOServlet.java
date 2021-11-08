package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
HttpServletResponse类
1.HttpServletResponse类的作用:
HttpServletResponse类和HttpServletRequest类一样。每次请求进来，Tomcat服务器都会创建一个Response对象传递给Servlet程序
去使用。HttpServletRequest表示请求过来的信息，HttpServletResponse表示所有响应的信息，我们如果需要设置返回给客户端的信息，
都可以通过HttpServletResponse对象来进行设置
2.两个输出流的说明:
2.1.字节流getOutputStream():常用于下载(传递二进制数据)
2.2.字符流getWriter():常用于回传字符(常用)
2.3.两个流同时只能使用一个。使用了字节流，就不能再使用字符流，反之亦然，否则就会报错。
 */
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决响应中文乱码方案一(不推荐使用)
        //设置服务器字符集为UTF-8
        //response.setCharacterEncoding("UTF-8");
        //通过响应头，设置浏览器也使用UTF-8字符集
        //response.setHeader("Content-Type", "text/html; charset=UTF-8");

        //解决响应中文乱码方案二(推荐)
        //它会同时设置服务器和客户端都使用UTF-8字符集，还设置了响应头
        //此方法一定要在获取流对象之前调用才有效
        response.setContentType("text/html; charset=UTF-8");

        //要求:往客户端回传字符串数据。
        PrintWriter writer = response.getWriter();
        writer.write("response's content!!!");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
