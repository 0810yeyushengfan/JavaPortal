package jiangjie1;

import org.junit.Test;

import java.io.*;

/*
缓冲流实现非文本文件的复制
 */
public class BufferedTest {
    @Test
    public void testBuffered() {
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try {
            //1.造文件
            File srcFile=new File("C:\\Users\\lenovo\\IdeaProjects\\untitled1\\day 26\\src\\jiangjie1\\testPicture1.PNG");
            File destFile=new File("C:\\Users\\lenovo\\IdeaProjects\\untitled1\\day 26\\src\\jiangjie1\\testPicture3.PNG");
            //2.造流
            //2.1造节点流
            FileInputStream fis=new FileInputStream(srcFile);
            FileOutputStream fos=new FileOutputStream(destFile);
            //2.2造缓冲流
            bis=new BufferedInputStream(fis);
            bos=new BufferedOutputStream(fos);
            //3.复制的细节:读取，写入
            byte[] buffer=new byte[1024];
            int len;
            while ((len=bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
                //bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求:先关闭外层的流，再关闭内层的流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            //说明:关闭外层流的同时，内层流也会自动的进行关闭，因此关于内层流的关闭，我们可以省略
//    fos.close();
//    fis.close();
        }
    }

    public void copyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try {
            //1.造文件
            File srcFile=new File(srcPath);
            File destFile=new File(destPath);
            //2.造流
            //2.1造节点流
            FileInputStream fis=new FileInputStream(srcFile);
            FileOutputStream fos=new FileOutputStream(destFile);
            //2.2造缓冲流
            bis=new BufferedInputStream(fis);
            bos=new BufferedOutputStream(fos);
            //3.复制的细节:读取，写入
            byte[] buffer=new byte[1024];
            int len;
            while ((len=bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
                //bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求:先关闭外层的流，再关闭内层的流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            //说明:关闭外层流的同时，内层流也会自动的进行关闭，因此关于内层流的关闭，我们可以省略
//    fos.close();
//    fis.close();
        }
    }

    @Test
    public void testCopyFileWithBuffered(){
        long start=System.currentTimeMillis();
        String srcPath="C:\\Users\\lenovo\\IdeaProjects\\untitled1\\day 26\\src\\jiangjie1\\testPicture1.PNG";
        String destPath="C:\\Users\\lenovo\\IdeaProjects\\untitled1\\day 26\\src\\jiangjie1\\testPicture4.PNG";
        copyFileWithBuffered(srcPath,destPath);
        long end=System.currentTimeMillis();
        System.out.println("复制操作花费的时间为"+(end-start));//5--->3
    }

    /*
    使用BufferedReader和BufferedWriter实现文本文件的复制
     */
    @Test
    public void testBufferefReaderBufferedWriter(){
        BufferedReader br=null;
        BufferedWriter bw=null;
        try{
            //创建文件和相应的流
            br=new BufferedReader(new FileReader(new File("C:\\Users\\lenovo\\IdeaProjects\\untitle1\\day 26\\src\\jiangjie1\\testPicture1.PNG" )));
            bw=new BufferedWriter(new FileWriter(new File("C:\\Users\\lenovo\\IdeaProjects\\untitled1\\day 26\\src\\jiangjie1\\testPicture5.PNG")));
            //读写操作
            //方法一:
//            char[] cbuf=new char[1024];
//            int len;
//            while ((len=br.read())!=-1){
//                bw.write(cbuf,0,len);
//                //bw.flush();
//            }}catch(IOException e){
//                e.printStackTrace();
                //方法二:使用String
            String data;
            while((data=br.readLine())!=null){
                //方法一:
//                bw.write(data+"\n");//data中不包括换行符
                //方法二:
                bw.write(data);
                bw.newLine();//提供换行的操作
            }}catch(IOException e){
                e.printStackTrace();
            }finally {
            //关闭资源
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        }


}
