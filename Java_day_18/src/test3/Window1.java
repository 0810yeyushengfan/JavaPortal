package test3;

public class Window1 implements Runnable{
    private int ticket=100;
    public void run(){
        while (true){
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+":"+ticket);
                ticket--;
            }else{
                break;
            }
        }

    }
}
