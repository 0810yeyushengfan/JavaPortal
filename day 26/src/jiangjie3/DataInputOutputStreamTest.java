package jiangjie3;

import org.junit.Test;

import java.io.*;

/*
三.数据流
1.为了方便地操作Java语言的基本数据类型和String的数据，可以使用数据流。
2. 数据流有两个类：(用于读取和写出基本数据类型、String类的数据）DataInputStream 和 DataOutputStream
分别“套接”在 InputStream 和 OutputStream 子类的流上
3.DataInputStream中的方法:
   boolean readBoolean() byte readByte()
   char readChar() float readFloat()
   double readDouble() short readShort()
   long readLong() int readInt()
   String readUTF() void readFully(byte[] b)
4.DataOutputStream中的方法:
   将上述的方法的read改为相应的write即可
 */
public class DataInputOutputStreamTest {
    //练习:将内存中的字符串，基本数据类型的变量写出到文件中
    //注意:处理异常的话，仍然使用try-catch-finally
    @Test
  public void test1() throws IOException {
        DataOutputStream dos=new DataOutputStream(new FileOutputStream("C:\\Users\\lenovo\\IdeaProjects\\untitled1\\day 26\\src\\jiangjie3\\data.txt"));
        dos.writeUTF("黄少天");
        dos.flush();//刷新操作，将内存中的数据写入文件
        dos.writeInt(23);
        dos.flush();
        dos.writeBoolean(true);
        dos.close();
    }
    //将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中
    //注意:读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致！
    @Test
    public void test2() throws IOException {
        DataInputStream dis=new DataInputStream(new FileInputStream("C:\\Users\\lenovo\\IdeaProjects\\untitled1\\day 26\\src\\jiangjie3\\data.txt"));
        String name=dis.readUTF();
        int age=dis.readInt();
        boolean isMale=dis.readBoolean();
        System.out.println("name="+name);
        System.out.println("age="+age);
        System.out.println("isMale="+isMale);
        dis.close();

    }
}
