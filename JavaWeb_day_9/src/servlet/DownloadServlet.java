package servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
/*
文件下载过程详解:
1.获取要下载的文件名:
使用String定义要下载的文件名
2.获取要下载的文件类型:
通过ServletContext的getMimeType()，参数是要下载的文件所在路径，返回值是String类型
3.将获取的文件类型告诉客户端:
通过response的setContentType()，参数是第二步的结果，无返回值
4.告诉客户端收到的数据用于下载使用(没有此步则内容直接显示在页面上):
通过response.setHeader()，参数是"Content-Disposition", “attachment; fileName=xxx.xxx"
注意:
Content-Disposition:响应头表示客户端收到的数据如何处理
attachment:表示附件，用于下载
filename:表示下载的文件名，可以与原文件名不同
5.获取要下载的文件并回传给客户端:
回传给客户端通过导入的io包的IOUtils.copy(InputStream input, OutputStream output)
通过ServletContext的getResourceAsStream()，参数是要下载的文件路径，得到输入流
通过response.getOutputStream()得到响应的输出流
*/

/*
response.setHeader("Content-Disposition", "attachment; fileName=1.jpg")
这个响应头告诉浏览器。这是需要下载的。
而attachment表示附件，也就是下载的一个文件。
fileName=后面表示下载的文件名。
完成上面的两个步骤下载文件是没问题了。但是如果我们要下载的文件是中文名的话。你会发现下载无法正确显示出正确的中文名。
原因是在响应头中，不能包含有中文字符，只能包含ASCII码。
方案一:URLEncoder解决IE和谷歌浏览器的附件中文名问题。
如果客户端浏览器是IE浏览器或者是谷歌浏览器。我们需要使用URLEncoder类先对中文名进行UTF-8的编码操作。
因为IE浏览器和谷歌浏览器收到含有编码后的字符串后会以UTF-8字符集进行解码显示。
方案二:BASE64编解码解决火狐浏览器的附件中文名问题
如果客户端浏览器是火狐浏览器。那么我们需要对中文名进行BASE64的编码操作。
这时候需要把请求头Content-Disposition:attachment;filename=中文名\
编码成为:Content-Disposition:attachment;filename==?charset?B?xxxxx?=
 */
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.获取要下载的文件名
        String downloadFile = "1.jpg";
        //2.通过ServletContext对象读取要下载的文件内容
        ServletContext servletContext = getServletContext();
        //获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFile);
        System.out.println("下载的文件类型" + mimeType);
        //3.在回传前，通过响应头告诉客户端返回的数据类型
        response.setContentType(mimeType);
        //4.还要告诉客户端收到的数据是用于下载使用(还是使用响应头)
        //Content-Disposition响应头，表示收到的数据怎么处理
        //attachment:表示附件，表示下载使用
        //filename=:表示指定下载的文件名
        if (request.getParameter("User-Agent").contains("Firefox")) {
            //如果是火狐浏览器,使用BASE64编码
            //=?charset?B?xxxxx?=
            //=?   表示编码内容的开始
            //charset  表示字符集
            //B        表示BASE64编码
            //xxxx     表示文件名BASE64编码后的内容
            //?=   表示编码内容的结束
            response.setHeader("Content-Disposition", "attachment; filename==?UTF-8?B?"
                    + new BASE64Encoder().encode("美女.jpg".getBytes("UTF-8")) + "?=");
        } else {
            //如果不是火狐，是IE或谷歌，使用URL编码操作
            //url编码是把汉字转换成为%xx%xx的格式
            response.setHeader("Content-Disposition", "attachment; filename="
                    + URLEncoder.encode("美女.jpg", "UTF-8"));
        }
        //5.把下载的文件内容回传给客户端
        //读取输入流中全部的数据，复制给输出流，输出给客户端
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFile);
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(resourceAsStream, outputStream);
    }
}