package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-------------doGet------------");
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobby = request.getParameterValues("hobby");
        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        System.out.println("兴趣爱好：" + Arrays.asList(hobby));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //快捷方式:设置请求体的字符集为UTF-8，从而解决post请求的中文乱码问题
        //必须要在获取请求参数之前调用才有效
//        request.setCharacterEncoding("UTF-8");
        System.out.println("-------------doPost------------");
        //获取请求参数
        String username = request.getParameter("username");
        //1.先以iso-8859-1进行编码
        //2.再以UTF-8进行解码
//      username = new String(username.getBytes("iso-8859-1"), "UTF-8");
        String password = request.getParameter("password");
        String[] hobby = request.getParameterValues("hobby");
        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        System.out.println("兴趣爱好：" + Arrays.asList(hobby));

    }
}
