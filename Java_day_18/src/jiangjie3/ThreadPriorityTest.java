package jiangjie3;
/*
线程的优先级:
1.(以下都是Thread类下的全局常量)
MAX_PRIORITY:10
MIN_PRIORITY:1
NORM_PRIORITY:5--->默认优先级
2.如何获取和设置当前线程的优先级:
    getPriority():获取线程的优先级
    setPriority(int p):设置线程的优先级
    说明:高优先级的线程抢占低优先级cpu的执行权，但是只是从概率上讲，高优先级的线程高概率的情况下被执行，
    并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行。
 */
public class ThreadPriorityTest {
    public static void main(String[] args) {
        PriorityThread h1=new PriorityThread("Thread:1");
        //设置分线程的优先级
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();
        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for(int i=0;i<100;i++){
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
