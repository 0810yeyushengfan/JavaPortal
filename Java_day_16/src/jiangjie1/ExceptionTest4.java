package jiangjie1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
异常处理的方法二:throw+异常类型
1."throw+异常类型"写在方法的声明处，指明此方法执行时，可能会抛出的异常类型。
  一旦当方法体执行时出现异常，仍会在异常代码处生成一个异常类的对象，此对象满足throws后异常类型时，
  就会被抛出，异常代码后续的代码也不再执行！
2.体会:try-catch-finally:真正的将异常处理了。
             throws的方式只是将异常抛给了方法的调用者，并没有真正的将异常处理掉。
3.开发中如何选择使用try-catch-finally还是throws呢？
   3.1如果父类中被重写的方法没有用throws方式处理异常，则子类重写的方法也不能使用throws，
   理解:父类没有用throws方式处理异常，说明父类的方法中不会出现编译时异常，不需要用try-catch-finally结构
             单独处理父类被重写的方法，只有子类重写的方法中才会出现编译时异常，因此只能用try-catch-finally
             结构单独处理子类重写的方法，要不然在利用多态性调用子类的重写的方法的时候，就不能处理子类
             重写的方法抛出的异常，因为父类被重写的方法根本不会抛出编译时异常。
       这意味着如果子类重写的方法有异常，必须使用try-catch-finally方法处理。
   3.2执行的方法a中，先后调用了另外的几个方法，这几个方法是递进关系执行的，我们建议这几个方法使用
         throw的方式进行处理，而执行的方法a可以考虑使用try-catch-finally方式进行处理。

 */
public class ExceptionTest4 {
    public static void main(String[] args) {
        try {
            method2();
        }catch (IOException e){
            e.printStackTrace();
        }
        method3();
    }
    public static void method3(){
        try {
            method1();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void method2() throws IOException {
        method1();
    }
    public static void method1() throws FileNotFoundException,IOException{
        File file=new File("hello.text");
        FileInputStream fis=new FileInputStream(file);
        int date=fis.read();
         while (date!=-1){
             System.out.println((char)date);
             date=fis.read();
        }
        fis.close();
         System.out.println("hahaha");
    }
}
