package jiangjie1;

public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1=new Window4();
        Window4 t2=new Window4();
        Window4 t3=new Window4();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
