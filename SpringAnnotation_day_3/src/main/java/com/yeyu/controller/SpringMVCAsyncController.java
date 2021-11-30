package com.yeyu.controller;

import com.yeyu.queue.DeferredResultQueue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;

@Controller
public class SpringMVCAsyncController {
    //模拟应用1的线程
    @ResponseBody
    @RequestMapping("/createOrder")
    public DeferredResult<Object> createOrder() {
        //设置响应时间和响应时间内没有响应时返回的错误提示消息
        //此处设置3秒没有响应就返回错误的提示消息"error: create fail..."
        DeferredResult<Object> deferredResult = new DeferredResult<Object>((long) 3000, "error: create fail...");
        //模拟消息队列的存储流程(即产生消息)
        DeferredResultQueue.save(deferredResult);
        //返回得到的订单号(即监听获取结果)
        return deferredResult;
    }

    //模拟应用2的线程
    @ResponseBody
    @RequestMapping("/create")
    public String create() {
        //创建订单号
        String orderNum = UUID.randomUUID().toString();
        //模拟消息队列的取用流程(即监听消费消息)
        DeferredResult<Object> deferredResult = DeferredResultQueue.get();
        //设置消费消息的订单号，createOrder()方法就会得到订单号并立即返回(即处理结果)
        deferredResult.setResult(orderNum);
        return "success===>orderNum:" + orderNum;
    }

}