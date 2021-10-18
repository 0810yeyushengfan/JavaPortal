package test3;

public class Account {
    private int id;
    private double balance;
    private double annuallnterestRate;
    public Account()
    {

    }
    public Account(int id,double balance,double annuallnterestRate)
    {
        this.id=id;
        this.balance=balance;
        this.annuallnterestRate=annuallnterestRate;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public void setBalance(double balance)
    {
       this.balance=balance;
    }
    public void setAnnuallnterestRate(double annuallnterestRate)
    {
        this.annuallnterestRate=annuallnterestRate;
    }
    public int getId()
    {
        return this.id;
    }
    public double getBalance()
    {
        return this.balance;
    }
    public double getAnnuallnterestRate()
    {
        return this.annuallnterestRate;
    }
    public void withdraw(double amount)
    {
        if(balance<amount)
        {
            System.out.println("余额不足，取款失败！");
            return;
        }
       balance-=amount;
        System.out.println("成功取出，"+amount);
    }
    public void deposit(double amount)
    {
        if(amount>0)
        {
            balance+=amount;
            System.out.println("成功存入"+amount);
        }
    }
}
