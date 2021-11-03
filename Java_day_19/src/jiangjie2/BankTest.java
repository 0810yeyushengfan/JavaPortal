package jiangjie2;

public class BankTest {
    public static void main(String[] args) {

            Bank bank1=Bank.getInstance();
            Bank bank2=Bank.getInstance();
            System.out.println(bank1==bank2);//true  证明bank1与bank2是同一个对象

    }
}
