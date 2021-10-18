package jiangjie1;

import org.junit.Test;

public class IDEADebugTest {
    /*
    结论:
    在StringBuffer的构造器中加入null会报NullPointerException异常
    在StringBuffer的append方法中加入null不会报错,而是会添加字符串"null"到StringBuffer的对象中
     */
    @Test
    public void testStringBuffer(){
        String str=null;
        StringBuffer sb=new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());//4
        System.out.println(sb);//"null"
        StringBuffer sb1=new StringBuffer(str);//报NullPointerException异常
        System.out.println(sb1);

    }
}
