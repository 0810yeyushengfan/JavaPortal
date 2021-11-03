package test4;
/*
写一个用户程序测试 Account 类。在用户程序中，创建一个账号为 1122、余额为 20000、
年利率 4.5%的 Account 对象。使用 withdraw 方法提款 30000 元，并打印余额。
再使用 withdraw 方法提款 2500 元，使用 deposit 方法存款 3000 元，然后打印余额和月利率。
 */
public class AccountTest {
    public static void main(String[] args) {
        Account acct=new Account(1122,20000,0.045);
        acct.withdraw(30000);
        System.out.println("您的账户的余额为"+acct.getBalance());
        System.out.println();
        acct.withdraw(2500);
        acct.deposit(3000);
        System.out.println("您的账户的余额为"+acct.getBalance());
        System.out.println("月利率为"+acct.getMonthlyInterest());
    }
}
