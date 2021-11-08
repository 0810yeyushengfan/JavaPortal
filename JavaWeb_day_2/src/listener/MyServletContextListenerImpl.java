package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/*
ServletContextListener监听器就是指javax.servlet.ServletContextListener
ServletContext监听器的使用步骤:
第一步:我们需要定义一个类。然后去继承生命周期的监听器接口。
第二步:然后在web.xml 文件中配置ServletContextListener监听器(一定要在web.xml文件中配置之后才会生效)
 */
public class MyServletContextListenerImpl implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext对象被创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象被销毁了");
    }
}
