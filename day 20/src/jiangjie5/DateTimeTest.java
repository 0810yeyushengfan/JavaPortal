package jiangjie5;

import org.junit.Test;

import java.util.Date;

/*
jdk 8之前的日期和时间的API测试
 */
public class DateTimeTest {
    /*
    1.System类中的currentTimeMillis()
     */
    @Test
    public void test1(){
        long time=System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间的以毫秒为单位的时间差
        //成为时间戳
        System.out.println(time);//1621831977017
    }

    /*
   2. java.util.Date类与 java.sql.Date类
      2.1.两者关系:java.util.Date类是 java.sql.Date类的父类
      2.2.两个构造器的使用:
            2.2.1.构造器一:Date():创建一个对应当前时间的Date对象
            2.2.2.构造器二:Date(long date):创建一个指定毫秒数的Date对象
      2.3.两个方法的使用:
            2.3.1 .toString():显示当前的年，月，日，时，分，秒
            2.3.2.getTime():获取当前Date对象对应的毫秒数（时间戳）
      2.4.java.sql.Date对应着数据库中的日期类型的变量
             2.4.1.如何实例化
                      调用Date(long date)的构造器
             2.4.2.如何将java.sql.Date对象转换为java.util.Date对象
                       因为java.util.Date类是 java.sql.Date类的父类，直接利用多态性即可
             2.4.3.如何将Java.util.Date对象转换为java.sql.Date对象
                      在java.sql.Date的构造器中调用java.util.Date的getTime方法获取时间戳


     */
    @Test
    public void test2(){
        //构造器一:Date():创建一个对应当前时间的Date对象
        Date date1=new Date();
        System.out.println(date1);//Mon May 24 22:42:35 CST 2021
        System.out.println(date1.getTime());//1621867375623
        //构造器二:Date(long date):创建指定毫秒数的Date对象
        Date date2=new Date(1621867375623L);
        System.out.println(date2);
        System.out.println(date2.toString());

        //创建java.sql.Date对象
        java.sql.Date date3=new java.sql.Date(1621867375623L);
        System.out.println(date3);//2021-05-24
        //如何将Java.util.Date对象转换为java.sql.Date对象
        //情况一:
        //Date date4=new java.sql.Date(1621867375623L);
        //java.sql.Date date5=(java.sql.Date) date4;
        //情况二:
        Date date6=new Date();
        java.sql.Date date7=new java.sql.Date(date6.getTime());




    }
}
