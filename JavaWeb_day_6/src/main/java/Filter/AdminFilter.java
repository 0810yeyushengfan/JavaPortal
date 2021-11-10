package Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
什么是过滤器?
1.Filter过滤器是JavaWeb的三大组件之一，三大组件分别是:Servlet程序.Listener监听器.Filter过滤器
2.Filter过滤器是JavaEE的规范，也就是接口
3.Filter过滤器的作用是:拦截请求，过滤响应。拦截请求常见的应用场景有:
3.1.权限检查
3.2.日记操作
3.3.事务管理......等等
 */

/*
Filter过滤器的使用步骤:
1.编写一个类去实现Filter接口
2.实现过滤方法doFilter()
3.到web.xml中去配置Filter的拦截路径
 */
public class AdminFilter implements Filter {
    /*
    Filter的生命周期包含几个方法:
    1.构造器方法
    2.init初始化方法
    第1.2步，在web工程启动的时候执行(Filter已经创建)
    3.doFilter过滤方法
    第3步，每次拦截到请求就会执行
    4.destroy销毁
    第4步，停止web工程的时候就会执行(停止web工程也会销毁Filter过滤器)
     */
    public AdminFilter() {
        System.out.println("这是1,Filter的构造器方法");
    }

    /*
    FilterConfig类，见名知义，它是Filter过滤器的配置文件类
    Tomcat每次创键Filter的时候，也会同时创建一个FilterConfig类，这里包含 Filter配置文件的配置信息。
    FilterConfig类的作用是获取filter过滤器的配置内容:
    1.获取Filter的名称<filter-name>的内容
    2.获取在Filter中配置的<init-param>初始化参数
    3.获取ServletContext对象
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("这是2,Filter的init()方法");
        //1.获取Filter的名称filter-name的内容
        System.out.println("filter-name的值是:" + filterConfig.getFilterName());
        //2.获取在Filter中配置的init-param初始化参数
        System.out.println("初始化参数username的值是:" + filterConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是:" + filterConfig.getInitParameter("url"));
        //3.获取ServletContext对象
        System.out.println("ServletContext的值是:" + filterConfig.getServletContext());
    }

    //专门用于拦截请求，过滤响应，可以做权限检查
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("这是2,Filter的doFilter()方法");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        if (user == null) {
            httpServletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            return;
        } else {
            //让程序继续往下访问用户的目标资源，此句不能缺少
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("这是2,Filter的destroy()方法");
    }
}