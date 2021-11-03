package jiangjie1;

/*
例子:创建三个窗口卖票，总票数为100张，使用继承Thread类的方式
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1=new Window2();
        Window2 t2=new Window2();
        Window2 t3=new Window2();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
