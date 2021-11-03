package jiangjie1;
/*
测试FileInputStream和FileOutputStream的使用
结论:
1.对于文本文件(.txt,.java.c.cpp)，使用字符流处理
2.对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt)，使用字节流处理
 */
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamTest {
    //使用字节流FileInputStream处理文本文件，可能会出现乱码
    @Test
    public void testFileInputStream(){
        FileInputStream fis=null;
        try{
            //1.造文件
            File file=new File("hello.txt");
            //2.造流
            fis=new FileInputStream(file);
            //3.读数据
            byte[] buffer=new byte[5];
            int len;//记录每次读取的字节的个数
            while((len=fis.read(buffer))!=-1){
                String str=new String(buffer,0,len);
                System.out.println(str);
            }}catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fis!=null) { //4.关闭资源
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    //指定路径下文件的复制
    public void copyFile(String srcPath,String destPath){
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try{
            //1.造文件
            File srcFile=new File(srcPath);
            File destFile=new File(destPath);
            //2.造流
            fis=new FileInputStream(srcFile);
            fos=new FileOutputStream(destFile);
            //复制的过程
            //3.读数据
            byte[] buffer=new byte[1024];
            int len;
            while((len=fis.read(buffer))!=-1){
                //4.写数据
                fos.write(buffer,0,len);
            }}catch(IOException e){
                e.printStackTrace();
            }finally {
            //5.关闭资源
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //实现非文本文件的复制
    @Test
    public  void  testCopyFile(){
        long start=System.currentTimeMillis();
        String srcPath="C:\\Users\\lenovo\\IdeaProjects\\untitled1\\day 26\\src\\jiangjie1\\testPicture1.PNG";
        String destPath="C:\\Users\\lenovo\\IdeaProjects\\untitled1\\day 26\\src\\jiangjie1\\testPicture2.PNG";
        copyFile(srcPath,destPath);
        long end=System.currentTimeMillis();
        System.out.println("复制操作花费的时间为 "+(end-start));//5
    }

}
