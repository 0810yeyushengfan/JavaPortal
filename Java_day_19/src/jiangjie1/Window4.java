package jiangjie1;
/*
静态方法中可以调用非静态方法，就比如本题中   System.out.println(Thread.currentThread().getName() + ":卖票，票号为:" + ticket);
静态的show方法中调用了非静态的getName方法。
非静态方法不能在静态方法中调用只是意味着不能直接的进行类的调用，但若是在静态方法中已经有了/new了
一个新的类的实例对象，通过这个实例对象进行对非静态方法的调用也是可行的。
不能直接调用是因为在类的加载的过程中静态方法加载，而非静态方法没有加载，所以无法调用。
但若是对类进行实例化得到一个类的对象之后，随着对象的加载 非静态方法也加载了，此时能调用非静态放啊。
 */
public class Window4 extends Thread{
    private static int ticket=100;
    public void run(){
        while (true) {
           show();
           if(ticket<=0)
               break;
        }
    }
    private static synchronized void show(){
        //private static synchronized void show(){//同步监视器:t1,t2,t3。这种解决方式是错误的
       //synchronized (Window2.class){
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ":卖票，票号为:" + ticket);
                ticket--;
            }
        //}
    }
}
