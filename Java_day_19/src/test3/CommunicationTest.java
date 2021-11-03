package test3;
/*
线程通信的例子:使用两个线程打印1~100。要求线程1，线程2交替打印。
涉及到的三个方法:
wait():一旦执行此方法，当前进程就进入阻塞状态，并释放同步监视器。
notify():一旦执行此方法，就会唤醒被wait的一个线程，如果有多个线程被wait，则唤醒优先级最高的线程，如果优先级相同，就随机唤醒一个线程。
notifyAll():一旦执行此方法，就会唤醒所有被wait的线程。
说明:
1.wait(),notify(),notifyAll()三个方法必须使用在同步代码块或同步方法中。
2.wait(),notify(),notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器。
   否则会出现IllegalMonitorStateException异常。
3.wait(),notify(),notifyAll()三个方法是定义在java.lang.Object类中的。

面试题:sleep()和wait()的异同
相同:一旦执行方法，都可以使得当前的线程进入阻塞状态。
不同:1.两个方法声明的位置不同:Thread类中声明sleep()，Object类中声明wait()
          2.调用的要求不同:sleep()可以在任何需要的场景下调用，wait()必须在同步代码块或同步方法中调用
          3.关于是否释放同步监视器:如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁
          4.方法的性质不同:sleep()是一个静态方法，可以直接通过Thread类进行调用，wait()是一个非静态方法，
             必须通过同步代码块或同步方法中的同步监视器进行调用。
  */
class Number implements Runnable{
    private int number=1;
    private Object obj=new Object();
    @Override
    public void run() {
        while (true){
            synchronized (obj){
                obj.notify();
                if (number<=100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}
public class CommunicationTest {
    public static void main(String[] args) {
        Number number=new Number();
        Thread thread1=new Thread(number);
        Thread thread2=new Thread(number);
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread1.start();
        thread2.start();
    }
}
