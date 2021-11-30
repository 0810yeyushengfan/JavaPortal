package com.yeyu.queue;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DeferredResultQueue {

    //模拟消息队列
    private static Queue<DeferredResult<Object>> queue = new ConcurrentLinkedQueue<DeferredResult<Object>>();

    //模拟消息队列的存储
    public static void save(DeferredResult<Object> deferredResult) {
        queue.add(deferredResult);
    }

    //模拟消息队列的取用
    public static DeferredResult<Object> get() {
        return queue.poll();
    }
}