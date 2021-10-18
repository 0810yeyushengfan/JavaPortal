package jiangjie1;
/*
使用同步代码块解决继承Thread类的方式的线程安全问题
例子:创建三个窗口卖票，总票数为100张，使用继承Thread类的方式
说明:在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。
 */


public class Window2 extends Thread{
    private static int ticket=100;
    private static Object obj=new Object();
    public void run(){
        while (true) {
            //正确的方式:
            //synchronized (obj) {
                synchronized (Window2.class){
                    //错误的方式:this代表着t1,t2,t3三个不同的对象
                    //sychronized(this){
                if (ticket > 0) {
                    System.out.println(getName() + ":卖票，票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
