package test4;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Account()
    {

    }
    public Account(int id,double balance,double annualInterestRate)
    {
        this.id=id;
        this.balance=balance;
        this.annualInterestRate=annualInterestRate;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    public double getMonthlyInterest()//计算月利率
    {
        return annualInterestRate/12;
    }
    public void withdraw (double amount)//取钱
    {
        if(balance>=amount)
        {
            balance-=amount;
            return;
        }
        System.out.println("余额不足!");
    }

    public void deposit (double amount)//存钱
    {
        if(amount>0)
        {
            balance+=amount;
        }
    }
}
