package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
1.请求重定向:
请求重定向，是指客户端给服务器发请求，然后服务器告诉客户端说。我给你一些地址。你去新地址访问。叫请求重定向(因为之前的地址可能已经被废弃)
2.请求重定向的特点(注意与请求转发做对比):
2.1.浏览器地址栏会发生变化
2.2.它们是两次请求
2.3.它们不能共享Request域中的数据
2.4.不可以转发到WEB-INF目录下(在正常状况下这个目录下的资源文件都是收到保护的，不能直接进行访问)
2.5.可以访问工程以外的资源(即其他网址)
 */
public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("曾到此一游 Response1 ");
        request.setAttribute("key1", "value1");

        //请求重定向的第一种方案:
        //设置响应状态码302，表示重定向(已搬迁)
        //response.setStatus(302);
        //设置响应头，说明新的地址在哪里
        //response.setHeader("Location", "http://localhost:8080/JavaWeb_day_1/Response2");
        //response.setHeader("Location", "https://www.baidu.com");

        //请求重定向的第二种方案(推荐使用):
        response.sendRedirect("https://www.baidu.com");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
