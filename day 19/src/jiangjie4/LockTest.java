package jiangjie4;

/*
解决线程安全问题的方式三:Lock锁----->jdk5.0新增特性
1.面试题:synchronized与Lock的异同
   相同:二者都可以解决线程安全问题
   不同:synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器。
             Lock需要手动的启动同步(lock())，同时结束同步也需要手动的实现(unlock())
2.优先使用顺序:
    Lock->同步代码块（已经进入了方法体，分配了相应资源）->同步方法（在方法体之外）
 */
public class LockTest {
    public static void main(String[] args) {
        Window w=new Window();
        Thread t1=new Thread(w);
        Thread t2=new Thread(w);
        Thread t3=new Thread(w);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
