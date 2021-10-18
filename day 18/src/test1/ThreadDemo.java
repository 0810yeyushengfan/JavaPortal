package test1;

/*
练习:创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //方法一:直接创建对象并调用
        //MyThread1 test1=new MyThread1();
        //MyThread2 test2=new MyThread2();
        //test1.start();
        //test2.start();
        //方法二:创建Thread类的匿名子类的匿名对象
        new Thread(){
            public void run(){
                for(int i=0;i<100;i++){
                    if(i%2==0){
                        System.out.println(i);
                    }
                }
            }
        }.start();
        new Thread(){
            public void run(){
                for(int i=0;i<100;i++){
                    if(i%2!=0){
                        System.out.println(i);
                    }
                }
            }
        }.start();
    }
}
