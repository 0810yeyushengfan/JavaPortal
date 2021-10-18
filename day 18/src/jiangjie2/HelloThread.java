package jiangjie2;

public class HelloThread extends Thread {
    public HelloThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            //if(i%20==0){
            //  yield();
            //}
        }
    }
}
