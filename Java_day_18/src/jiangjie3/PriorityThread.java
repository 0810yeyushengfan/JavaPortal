package jiangjie3;

public class PriorityThread extends Thread{
    public void run(){
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(getName()+":"+i);
            }
        }
    }
    public PriorityThread(String name){
        super(name);
    }
}
