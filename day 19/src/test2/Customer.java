package test2;

public class Customer extends Thread{
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }
    public void run(){
        for(int i=0;i<3;i++){
            acct.deposit(1000);
        }
    }

}
