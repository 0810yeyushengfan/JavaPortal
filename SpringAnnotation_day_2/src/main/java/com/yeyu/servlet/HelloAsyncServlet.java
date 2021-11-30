package com.yeyu.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//1.在@WebServlet注解中配置asyncSupported=true，表示当前Servlet支持异步处理
@WebServlet(value = "/async", asyncSupported = true)
public class HelloAsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("主线程开始。。。" + Thread.currentThread() + "==>" + System.currentTimeMillis());
        //2.对当前请求开启异步模式，返回异步上下文
        AsyncContext startAsync = req.startAsync();
        //3.调用异步上下文的start()方法进行异步处理，在副线程中编写业务逻辑
        startAsync.start(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("副线程开始。。。" + Thread.currentThread() + "==>" + System.currentTimeMillis());
                    sayHello();
                    //4.获取到当前请求的异步上下文(只有当前请求开启的异步模式才能调用此方法)，也可以直接用上面的startAsync
                    AsyncContext asyncContext = req.getAsyncContext();
                    //5.获取异步上下文的响应
                    ServletResponse response = asyncContext.getResponse();
                    response.getWriter().write("hello async...");
                    System.out.println("副线程结束。。。" + Thread.currentThread() + "==>" + System.currentTimeMillis());
                    //6.调用异步上下文的complete()方法，告知项目异步处理完毕，并返回项目设置的异步上下文的响应
                    startAsync.complete();
                } catch (Exception e) {
                }
            }
        });
        System.out.println("主线程结束。。。" + Thread.currentThread() + "==>" + System.currentTimeMillis());
    }

    public void sayHello() throws Exception {
        System.out.println(Thread.currentThread() + " processing...");
        Thread.sleep(3000);
    }
}
