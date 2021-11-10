package Filter;

import javax.servlet.*;
import java.io.IOException;

public class Filter2 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter2前置代码");
        System.out.println("Filter2所在的线程"+Thread.currentThread().getName());
        System.out.println("Filter2所持有的Request"+request);
        chain.doFilter(request, response);
        System.out.println("Filter2后置代码");
    }
}
