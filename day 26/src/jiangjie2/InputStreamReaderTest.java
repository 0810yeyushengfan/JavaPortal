package jiangjie2;

import org.junit.Test;

import java.io.*;

/*
一.转换流:属于字符流
1.InputStreamReader:将一个字节的输入流转换为字符的输入流
2.OutputStreamWriter:将一个字节的输出流转换为字符的输出流
二.作用
提供字节流和字符流之间的转换
三.解码与编码
1.解码:字节，字节数组---->字符数组，字符串
2.编码:字符数组，字符串---->字节，字节数组
四.字符集
 */

//注意:此时处理异常的话仍需要用try-catch-finally
//InputStreamReader的使用:实现字节的输入流到字符的输入流的转换
public class InputStreamReaderTest {
 @Test
    public void test1() throws IOException {
     FileInputStream fis=new FileInputStream("C:\\Users\\lenovo\\IdeaProjects\\untitled1\\day 26\\src\\jiangjie2\\haha.txt");
    // InputStreamReader isr=new InputStreamReader(fis);//使用系统默认的字符集
     //参数2指明了字符集，具体使用哪个字符集，取决于文件haha.txt保存时使用的字符集
     InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
     char[] cbuf=new char[20];
     int len;
     while((len=isr.read(cbuf))!=-1){
      String str=new String(cbuf,0,len);
      System.out.println(str);
     }
     isr.close();
 }

 //注意:此时处理异常的话仍需要用try-catch-finally
 //复制文件
 @Test
 public void test2() throws IOException {
  //1.造文件，造流
  File file1=new File("C:\\Users\\lenovo\\IdeaProjects\\untitled1\\day 26\\src\\jiangjie2\\haha.txt");
  File file2=new File("C:\\Users\\lenovo\\IdeaProjects\\untitled1\\day 26\\src\\jiangjie2\\hahaCopy.txt");
  FileInputStream fis=new FileInputStream(file1);
  FileOutputStream fos=new FileOutputStream(file2);
  InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
  OutputStreamWriter osw=new OutputStreamWriter(fos,"gbk");
  //2.读写过程
  char[] cbuf=new char[20];
  int len;
  while((len=isr.read(cbuf))!=-1){
   osw.write(cbuf,0,len);
  }
  //3.关闭资源
  isr.close();
  osw.close();

 }

}
