package jiangjie4;

//1.创建一个实现了Runnable接口的类
public class RunnableThread implements Runnable {
    //2.实现类去实现Runnable接口中的抽象方法:run()
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
