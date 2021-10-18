package jiangjie4;

/*
创建多线程的方式二:实现Runnable接口
1.创建一个实现了Runnable接口的类
2.实现类去实现Runnable接口中的抽象方法:run()
3.创建实现类的对象（即Runnable接口子类的实例化对象）
4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
5,通过Thread类的对象调用strat():1.启动线程  2.调用当前线程的run()--->调用了Runnable类型的target的run()

比较创建线程的两种方法:
开发中:优先选择:实现Runnable接口的方式
原因:1.实现的方式没有类的单继承性的局限性
          2.实现的方式更适合来处理多个线程有共享数据的情况
 联系:public class Thread implements Runnable
 相同点:两种方式都需要重写run()，将线程要执行的逻辑声明在run()中

 在看Thread源码时自己的一点理解:
 Thread类实现了Runnable接口，
在构造器中如果不加入Runnable以及其子类，Thread类的属性Runnable类的target就为null，
在run方法中，如果target不为null，就执行target的run方法，如果为null，就执行自己的run方法。
因此在直接继承Thread类的线程中，没有引入target，所以在start时执行的便是继承Thread类中重写的run方法。
而在用Runnable接口实现类构造Thread类并用Thread类调用start方法的线程中，构造使用的Runnable接口被我们
定义的一个类实现，并且重写了run方法，我们用这个类的对象构造Thread类的对象，所以这个对象就是Thread类
中的target，在Thread类的对象调用run时，实际上调用的是我们定义的一个实现了Runnable接口的类中的重写好了的run方法。
由于多个Thread类的对象构造的时候使用的都是同一个实现了Runnable接口的类的对象，因此天生的就能共享这
个对象的属性和方法。而直接继承Thread类，如果想要开辟多个线程，就必须构造多个继承了Thread类的子类的
对象，这几个对象相互独立，因此不能共享对象中的属性和方法，只有人为的用static关键字规定，才能共享指定的属性和方法。
 */
public class RunnableTest {
    public static void main(String[] args) {
        // 3.创建实现类的对象（即Runnable接口子类的实例化对象）
        RunnableThread mThread = new RunnableThread();
        //4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(mThread);
        //5,通过Thread类的对象调用strat():1.启动线程  2.调用当前线程的run()--->调用了Runnable类型的target的run()
        t1.start();
    }

}
