package jiangjie1;

public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread t1 = new MyThread();
        //4.通过此对象调用start()
        //作用:
        // 4.1启动当前线程
        //4.2调用当前线程的run()
        t1.start();
        //问题一:我们不能通过直接调用run()的方式启动线程
        //t1.run();
        //问题二:再启动一个线程，遍历100以内的偶数，不可以还让已经strat()的线程去执行，会报IllegalThreadStateException异常
        //t1.start();
        //我们只需要重新创建一个线程的对象
        MyThread t2=new MyThread();
        t2.start();
        //如下操作仍然是在main线程中执行的
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName()+":"+i + "*******main()*******");
            }
        }
    }
}
