package jiangjie5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
创建线程的方式三:实现Callable接口。----->jdk5.0新增特性

实现步骤
1.创建一个实现Callable接口的实现类。
2.在此实现类中实现call方法，将此线程需要执行的操作声明在call()中。
3.创建Callable接口实现类的对象。
4.将此Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象。
5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread类的对象，并调用start()方法。
6.用get()方法获取Callable中call方法的返回值。

如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程强大？
1.call()可以有返回值。
2.call()可以抛出异常，被外面的操作捕获，获取异常的信息。
3.Callable是支持泛型的。
 */
//1.创建一个实现Callable接口的实现类。
class NumThread implements Callable{

    //2.在此实现类中实现call方法，将此线程需要执行的操作声明在call()中。
    @Override
    public Object call() throws Exception {
        int sum=0;
        for(int i=1;i<=100;i++){
            if(i%2==0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}
public class ThreadNew {
    public static void main(String[] args) {
    //3.创建Callable接口实现类的对象。
        NumThread numThread=new NumThread();
    //4.将此Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象。
        FutureTask futureTask=new FutureTask(numThread);
    //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread类的对象，并调用start()方法。
        Thread thread=new Thread(futureTask);
        thread.start();
    //6.用get()方法获取Callable中call方法的返回值。
        Object sum= null;
        try {
            sum = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("总和为 :"+sum);

    }

}
