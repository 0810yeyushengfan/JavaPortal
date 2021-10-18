package jiangjie3;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringTest {
    /*
    复习:String与基本数据类型，包装类之间的转换
    String--->基本数据类型，包装类:调用包装类的静态方法:parseXxx(str)
    基本数据类型，包装类--->String:调用String重载的valueOf(xxx)
     */
    @Test
    public void test1(){
        String str1="123";
        //int num=(int) str1;//错误的
        int num=Integer.parseInt(str1);//123
        String str2=String.valueOf(num);//"123"
        String str3=num+"";
        System.out.println(str2==str3);//false    str2在常量池中.str3在堆中

    }
    /*
    String与char[]之间的转换
    String--->char[]:调用·String的toCharArray()
    char[]--->String:调用String的构造器(String内含一个char[] 的构造器)
     */
    @Test
    public void test2(){
        String str1="abc123";
        char[] charArray=str1.toCharArray();
        for(int i=0;i<charArray.length;i++){
            System.out.println(charArray[i]);
        }
        char[] arr=new char[]{'h','e','l','l','o'};
        String str2=new String(arr);
        System.out.println(str2);
    }
    /*
    String和byte[]之间的转换
    编码:String--->byte[]:调用String的getBytes()
    解码:byte[]--->String:调用String的构造器
    编码:字符串--->字节（看得懂--->看不懂的二进制数据）
    解码:编码的逆过程，字节--->字符串（看不懂的二进制数据--->看得懂）
    说明:解码时，要求解码使用的字符集必须和编码使用的字符集一致，否则会出现乱码

     */
    @Test
    public void test3(){
        String str1="abc123中国";
        byte[] bytes=str1.getBytes();//使用默认的字符集进行转换
        System.out.println(Arrays.toString(bytes));
        byte[] gbks= new byte[0];
        try {
            gbks = str1.getBytes("gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(gbks));

        System.out.println("*********************");
        String str2=new String(bytes);//使用默认的字符集进行解码
        System.out.println(str2);

        String str3=new String(gbks);
        System.out.println(str3);//出现乱码，原因:编码集和解码集不一致

        String str4= null;
        try {
            str4 = new String(gbks,"gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(str4);//没有出现乱码，原因:编码集和解码集一致
    }
}
