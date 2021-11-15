package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
什么是Listener监听器?
1.Listener监听器是JavaWeb的三大组件之一。JavaWeb的三大组件分别是:Servlet程序.Filter过滤器.Listener监听器。
2.listener是JavaEE的规范，规范就是接口
3.监听器的作用是监听某种事物的变化。然后通过回调函数反馈给客户(程序)去做一些相应的处理。

ServletContextListener监听器就是指javax.servlet.ServletContextListener，可以监听ServletContext对象的创建和销毁。
ServletContext对象在web工程启动的时候创建，在web工程停止的时候销毁。监听到创建和销毁之后都会分别调用ServletContextListener
监听器的方法反馈。

ServletContext监听器的使用步骤:
1.编写一个类去实现ServletContextListener接口
2.实现其两个回调方法
3.到web.xml中去配置监听器
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
