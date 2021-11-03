package jiangjie4;

import java.util.concurrent.locks.ReentrantLock;

public class Window implements Runnable{
    private int ticket=100;
    //1.实例化ReentrantLock
    private ReentrantLock lock=new ReentrantLock();
    public void run(){
        while (true){
            try{
                //2.调用锁定方法lock()
                lock.lock();
                if(ticket>0){
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":卖票:票号为"+ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally {
                //3.调用解锁方法:(unlock())
                lock.unlock();
            }
        }
    }
}
