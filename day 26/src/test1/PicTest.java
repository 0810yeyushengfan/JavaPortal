package test1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
图片的加密
 */
public class PicTest {
    public static void main(String[] args) {
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try{
            fis=new FileInputStream("C:\\Users\\lenovo\\IdeaProjects\\untitled1\\day 26\\src\\jiangjie1\\testPicture1.PNG");
            fos=new FileOutputStream("C:\\Users\\lenovo\\IdeaProjects\\untitled1\\day 26\\src\\jiangjie1\\testPicture1.PNG");
            byte[] buffer=new byte[20];
            int len;
            while((len=fis.read(buffer))!=-1){
                //字节数组进行修改
                //错误的:
//                for(byte b:buffer){
//                    b=(byte) (b^5);
//                }
                //正确的:
                for(int i=0;i<len;i++){
                    buffer[i]=(byte) (buffer[i]^5);
                }
                fos.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
