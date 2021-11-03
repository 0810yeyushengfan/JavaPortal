package jiangjie4;

import org.junit.Test;

/*
关于StringBuffer和StringBuilder的使用
 */
public class StringBufferBuilderTest {
    /*
    String,StringBuffer,StringBuilder三者的异同？
    String:不可变的字符序列。
    StringBuffer:可变的字符序列，线程安全的，效率低。
    StringBuilder:可变的字符序列，jdk5.0新增的，线程不安全的效率高。
    注:1.不可变的是指在操作中对String变换或者赋值了一个新的字符串时，会再new一个新的字符串，
            让String从指向旧的字符串改为指向新的字符串
         2.可变的是指在操作中对String变换或者赋值了一个新的字符串时，不再new一个新的字符串，
            而是对原有的字符串进行修改。
         3.因此所谓的可变不可变是针对原有的字符串而言的。
    源码分析:
    String str=new String();//char[] value=new char[0];
    String str1=new String();//char[] value=new char[]{'a','b','c'};

    Stringbuffer sb1=new StringBuffer();//char[] value=new char[16];第层创建了一个长度是16的字符数组
    System.out.println(sb1.length());//0
    sb1.append('a');//value[0]='a';
    sb1.append('b');//value[1]='b';

    StringBuffer sb2=new StringBuffer("abc");//char[] value=new char["abc".length()+16];

    //问题1:System.out.println(sb2.length());//3
                   StringBuffer内的字符数组长度的大小不影响字符数组内存的子符的数量
        问题2:扩容问题:如果要添加的数据底层数组盛不下了  那就需要扩容底层的数组
                     默认情况下，扩容为原来容量的2倍＋2，同时将原有数组的元素复制到新的数组中。

                     指导意义:开发中建议大家使用StringBuffer(int capacity)//cabacity:容量，这个构造器能构造指定容量的StringBuffer
     */
    @Test
    public void test1() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());//0
    }

    /*
    StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
    StringBuffer delete(int start,int end)：删除指定位置的内容
    StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
    StringBuffer insert(int offset, xxx)：在指定位置插入xxx
    StringBuffer reverse() ：把当前字符序列逆转
    public int indexOf(String str):顺序查找字符字串str在字符串中首次出现的位置，字符串中找不到返回-1
    public String substring(int start,int end):返回字符串[start,end)位置的字符子串,不会改变原来的字符串
    public int length():返回字符串长度
    public char charAt(int n ):返回字符串第n个位置的字符
    public void setCharAt(int n ,char ch):把字符串第n个位置的字符换为ch字符

    总结:
    增:append(xxx)
    删:delete(int start,int end)
    改:setCharAt(int n,char ch)/replace(int start,int end,String str)
    查:charAt(int n)
    插:insert(int offset,xxx)
    长度:length()
    遍历:for()+charAt()/toString()

     */
    @Test
    public void test2() {
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');//StringBuffer中有多个构造器，不论输入的是什么基本数据类型，都会转换成字符串
        System.out.println(s1);
        //s1.delete(2,4);
        // s1.replace(2,4, "hello");
        //s1.insert(2,false);
        //s1.reverse();
        String s2=s1.substring(1,3);
        System.out.println(s2);
        System.out.println(s1);
        System.out.println(s1.length());
        char s=s1.charAt(2);
        System.out.println(s);
        s1.setCharAt(2,'A');
        System.out.println(s1);
        int ss=s1.indexOf("bA");
        System.out.println(ss);
        int sss=s1.indexOf("ba");
        System.out.println(sss);

    }
    /*
    对比String,StringBuffer,StringBuilder三者的效率
    从高到低排列，StringBuilder>StringBuffer>String

     */
    @Test
    public void test3(){
        //初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
//开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i; }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
    }
    /*
    String与StringBuffer,StringBuilder之间的转换
    String--->StringBuffer,StringBuilder:调用StringBuffer,StringBuilder的构造器
    StringBuffer,StringBuilder--->String:调用String构造器或者调用StringBuffer,StringBuilder的toString()方法
     */
    @Test
    public void test4(){
        String s1="abc";
        StringBuffer s2=new StringBuffer(s1);
        StringBuilder s3=new StringBuilder(s1);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        StringBuilder s4=new StringBuilder("def");
        String s5=new String(s4);
        String s6=s4.toString();
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);

    }
}
