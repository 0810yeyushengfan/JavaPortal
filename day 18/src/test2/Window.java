package test2;

public class Window extends Thread{
    private static int ticket=100;
    public void run(){
        while (true){
            if(ticket>0){
                System.out.println(getName()+":卖票，票号为:"+ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}
