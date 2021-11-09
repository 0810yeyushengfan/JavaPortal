package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
什么是Session会话?
1.Session就是一个接口(HttpSession)
2.Session就是会话，它是用来维护一个客户端和服务器之间关联的一种技术。
3.每个客户端都有自己的一个Session会话
4.Session会话中，我们经常用来保存用户登录之后的信息。
//Session技术的底层是基于Cookie技术来实现的!!!
 */
public class SessionServlet extends BaseServlet {

    /*
    1.如何创建和获取Session?
    它们的API是一样的，都是request.getSession()
    第一次调用是创建Session会话，之后调用都是获取前面创建好的Session会话对象
    2.如何判断获取的Session是否为新创建出来的?
    isNew():判断到底是不是刚创建出来的(新的)
    true表示刚创建，false表示获取之前创建
    3.如何获取Session的ID值?
    每个会话都有一个身份证号，也就是ID值，而且这个ID是唯一的。
    getId():得到Session的会话id值。
     */
    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取Session会话对象
        HttpSession session = req.getSession();
        //判断当前Session会话，是否是新创建出来的
        boolean isNew = session.isNew();
        //获取Session会话的唯一标识id
        String id = session.getId();
        resp.getWriter().write("得到的Session的id是:" + id + " <br /> ");
        resp.getWriter().write("这个Session是否是新创建的:" + isNew + " <br /> ");


    }

    //往Session中保存数据
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");
        resp.getWriter().write("已经往Session中保存了数据");

    }

    //获取Session域中的数据
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("从Session中获取出key1的数据是:" + attribute);
    }

    /*
    Session生命周期控制:
    1.public void setMaxInactiveInterval(int interval):
    设置Session的超时时间(以秒为单位)，超过指定的时长，Session就会被销毁。
    值为正数:设定Session的超时时长。
    值为负数:表示永不超时(极少使用)
    2.public int getMaxInactiveInterval():
    获取Session的超时时间
    3.public void invalidate():
    让当前Session会话马上超时无效
    4.Session默认的超时时长是多少?
    Session默认的超时时间长为30分钟。因为在Tomcat服务器的配置文件web.xml中默认有以下的配置，它就表示配置了当前Tomcat
    服务器下所有的Session超时配置默认时长为30分钟。
    <session-config> <session-timeout>30</session-timeout> </session-config>
    如果说你希望你的web工程默认的Session的超时时长为其他时长。你可以在你自己的web.xml配置文件中做以上相同的配置。
    就可以修改你的web工程所有Seession的默认超时时长
    <!--表示当前web工程创建出来的所有Session默认是20分钟超时时长-->
    <session-config> <session-timeout>20</session-timeout> </session-config>
    如果你想只修改个别Session的超时时长。就可以使用上面的API(setMaxInactiveInterval(int interval))来进行单独的设置。session.setMaxInactiveInterval(int interval)单独设置超时时长
     */
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取了Session的默认超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("Session的默认超时时长为:" + maxInactiveInterval + " 秒 ");
    }

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取Session对象
        HttpSession session = req.getSession();
        //设置当前Session3秒后超时
        //Session超时指的是客户端两次请求的最大时间间隔
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("当前Session已经设置为3秒后超时");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取Session对象
        HttpSession session = req.getSession();
        //让Session会话马上超时
        session.invalidate();
        resp.getWriter().write("Session已经设置为超时（无效）");
    }


}
