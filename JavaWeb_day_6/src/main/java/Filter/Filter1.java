package Filter;

import javax.servlet.*;
import java.io.IOException;
/*
Filter:过滤器
Chain:链，链条
FilterChain:就是过滤器链(多个过滤器如何一起工作)
多个Filter过滤器执行的特点:
1.所有Filter和目标资源默认都执行在同一个线程中
2.多个Filter共同执行的时候，它们都使用同一个Request对象
3.多个Filter过滤器执行的时候，它们执行的优先顺序是由它们在web.xml中从上到下配置的顺序决定的
 */
public class Filter1 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    //FilterChain.doFilter()方法的作用:
    //1.执行下一个Filter过滤器(如果还有Filter的话)
    //2.执行目标资源(如果没有Filter的话)
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter1前置代码");
        System.out.println("Filter1所在的线程"+Thread.currentThread().getName());
        System.out.println("Filter1所持有的Request"+request);
        chain.doFilter(request, response);
        System.out.println("Filter1后置代码");
    }
}
