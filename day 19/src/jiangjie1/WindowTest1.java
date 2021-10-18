package jiangjie1;
/*
例子:创建三个窗口卖票，总票数为100张，使用实现Runnable接口的方式
 */
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w=new Window1();
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
