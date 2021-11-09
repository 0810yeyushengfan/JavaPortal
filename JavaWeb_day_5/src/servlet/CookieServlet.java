package servlet;

import util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
什么是Cookie?
1.Cookie翻译过来是饼干的意思。
2.Cookie是服务器通知客户端保存键值对的一种技术。
3.客户端有了Cookie后，每次请求都发送给服务器。
4.每个Cookie的大小不能超过4kb
 */
public class CookieServlet extends BaseServlet {


    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        // getContextPath() ===>>>>  得到工程路径
        cookie.setPath(req.getContextPath() + "/abc"); // ===>>>>  /工程路径/abc
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有Path路径的Cookie");
    }

    //Cookie值的修改
    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        方案一:
//        1.先创建一个要修改的同名的Cookie对象
//        2.在构造器中同时赋于新的Cookie值。
//        Cookie cookie = new Cookie("key1","newValue1");
//        3.调用response.addCookie(Cookie)通知客户端保存修改
//        resp.addCookie(cookie);

//        方案二:
//        1.先查找到需要修改的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key2", req.getCookies());
        if (cookie != null) {
//        2.调用setValue()方法赋于新的Cookie值。
            cookie.setValue("newValue2");
//        3.调用response.addCookie(Cookie)通知客户端保存修改
            resp.addCookie(cookie);
        }
        resp.getWriter().write("key1的Cookie已经修改好");
    }

    /*
    Cookie的生命控制指的是如何管理Cookie，即Cookie什么时候被销毁(删除)
    设置setMaxAge()中的参数:
    1.正数:表示在指定的秒数后过期
    2.负数:表示浏览器一关，Cookie就会被删除(默认值是-1)
    3.零:表示马上删除Cookie
     */
    //设置存活1个小时的Cookie
    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("life3600", "life3600");
        cookie.setMaxAge(60 * 60); // 设置Cookie一小时之后被删除。无效
        resp.addCookie(cookie);
        resp.getWriter().write("已经创建了一个存活一小时的Cookie");
    }

    //马上删除一个Cookie
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先找到你要删除的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key4", req.getCookies());
        if (cookie != null) {
            //调用setMaxAge(0)
            cookie.setMaxAge(0); // 表示马上删除，都不需要等待浏览器关闭
            //调用response.addCookie(cookie)，通知客户端保存Cookie
            resp.addCookie(cookie);
            resp.getWriter().write("key4的Cookie已经被删除");
        }

    }

    //默认的会话级别的Cookie
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defalutLife", "defaultLife");
        cookie.setMaxAge(-1);//设置存活时间
        resp.addCookie(cookie);
    }

    //服务器获取客户端的Cookie
    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            //getName()方法返回Cookie的key(名)
            //getValue()方法返回Cookie的value(值)
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "] <br/>");
        }
        Cookie iWantCookie = CookieUtils.findCookie("key1", cookies);
//        for (Cookie cookie : cookies) {
//            if ("key2".equals(cookie.getName())) {
//                iWantCookie = cookie;
//                break;
//            }
//        }
        // 如果不等于null，说明赋过值，也就是找到了需要的Cookie
        if (iWantCookie != null) {
            resp.getWriter().write("找到了需要的Cookie");
        }
    }

    //通过服务器通知客户端创建一个Cookie
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie cookie = new Cookie("key4", "value4");
        //2.通知客户端保存Cookie
        resp.addCookie(cookie);
        //1.创建Cookie对象
        Cookie cookie1 = new Cookie("key5", "value5");
        //2.通知客户端保存Cookie
        resp.addCookie(cookie1);
        resp.getWriter().write("Cookie创建成功");
    }
}
