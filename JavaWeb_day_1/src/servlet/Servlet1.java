package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
请求转发的特点:
1.浏览器地址栏没有变化
2.它们是一次请求
3.它们共享Request域中的数据
4.可以转发到WEB-INF目录下(在正常状况下这个目录下的资源文件都是收到保护的，不能直接进行访问)
5.不可以访问工程以外的资源(即其他网址)
 */
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数(办事的材料)
        String username = request.getParameter("username");
        System.out.println("在 Servlet1(柜台1)中查看参数(材料):" + username);
        //给材料盖一个章，并传递到Servlet2(柜台2)去查看
        request.setAttribute("key1","柜台1的章");
        //问路:Servlet2(柜台2)怎么走
        //请求转发必须要以斜杠打头，/(斜杠)表示地址为:http://ip:port/工程名/,即映射到IDEA代码的web目录
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Servlet2");
        //RequestDispatcher requestDispatcher = request.getRequestDispatcher("http://www.baidu.com");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/b.html");
        //走向Sevlet2(柜台2)
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
