package jiangjie1;

import java.util.Date;
import java.util.Scanner;

/*
一.java异常体系
java.lang.Throwwable
         |-----java.lang.Error:一般不编写针对性的代码进行处理
         |-----java.lang.Exception:可以进行异常的处理
                  |-----编译时异常（checked）
                            |-----IOException
                                     |-----FileNotFoundException
                             |-----ClassNotFoundException
                  |-----运行时异常（unchecked)
                           |-----NullPointerException
                           |-----ArrayIndexOutOfBoundsException
                           |-----ClassCastException
                           |-----NumberFormatException
                           |-----InputMismatchException
                           |-----ArithmeticException
二.面试题:常见的异常都有哪些？举例说明
     以下全是例子
 */
public class ExceptionTest1 {
    public static void main(String[] args) {
        //*************************************以下是编译时异常************************************************
        //File file=new File("hello.text");
        //FileInputStream fis=new FileInputStream(file);
        // int date=fis.read();
        // while (date!=-1){
        //    System.out.println((char)date);
        //    date=fis.read();
        //}
        //fis.close();
        //*************************************以下是运行时异常************************************************
        //NullPointerException
         int[] arr=null;
        System.out.println(arr[3]);
        String str="abc";
        str=null;
        System.out.println(str.charAt(0));
        //ArrayIndexOutOfBoundsException
        int[] arr1=new int[10];
        System.out.println(arr1[10]);
        //StringIndexOutOfBoundsException
        String str1="abc";
        System.out.println(str1.charAt(3));
         //ClassCastException
        Object obj=new Date();
        String str2=(String)obj;
        //NumberFormatException
        String str3="123";
        str3="abc";
        int num=Integer.parseInt(str);
        //InputMismatchException
        Scanner scanner=new Scanner(System.in);
        int score=scanner.nextInt();//此时输入不是数字的东西
        System.out.println(score);
        //ArithmeticException
        int a=10;
        int b=0;
        System.out.println(a/b);
    }
}
