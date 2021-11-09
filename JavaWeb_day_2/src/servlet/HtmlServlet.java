package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/*
什么是jsp?
JSP(全称Java Server Pages)，是由Sun公司专门为了解决动态生成HTML文档的技术。jsp的主要作用是代替Servlet程序回传
html页面的数据。因为Servlet程序回传html页面数据是一件非常繁锁的事情。开发成本和维护成本都极高。
 */
public class HtmlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Servlet程序输出html页面:
        //在学习jsp技术之前，如果我们要往客户端输出一个页面。我们可以使用Servlet程序来实现

        //设置返回的数据内容的数据类型和编码
        response.setContentType("text/html; charset=utf-8");
        //获取字符输出流
        Writer writer = response.getWriter();
        //输出页面内容
        writer.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        writer.write("<title>Insert title here</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("这是由Servlet程序输出的html页面内容!");
        writer.write("</body></html>");

        //上面的代码我们不难发现。通过Servlet输出简单的html页面信息都非常不方便。
        //那我们要输出一个复杂页面的时候，就更加的困难，而且不利于页面的维护和调试。
        //所以sun公司推出一种叫做jsp的动态页面技术帮助我们实现对页面的输出繁锁工作。
        //注意:jsp页面的访问千万不能像HTML页面一样。托到浏览器中。只能通过浏览器访问Tomcat服务器再访问jsp页面。
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
