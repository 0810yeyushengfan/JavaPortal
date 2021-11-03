package jiangjie1;
/*
使用同步方法解决实现Runnable接口的线程安全问题
关于同步方法的总结:
1.同步方法仍然涉及到同步监视器，只是不需要我们显式的声明
2.非静态的同步方法:同步监视器是:this
    静态的同步方法:同步监视器是:当前类本身
 */
public class Window3 implements Runnable{
    private int ticket=100;
    public void run(){
        while (true) {
           show();
           if(ticket <=0)
               break;
        }
    }
    private synchronized void show(){//同步监视器:this
        //synchronized(this){
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + ticket);
                ticket--;
            }
       // }
    }
}

