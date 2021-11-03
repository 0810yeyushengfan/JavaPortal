package test1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
实现TCP的网络编程
例子2:客户端发送文件给服务端，服务端将文件保存在本地
 */
public class TCPTest2 {
    //客户端
    @Test
    public void client(){
        Socket socket=null;
        OutputStream os=null;
        FileInputStream fis=null;
        try {
            socket=new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            os=socket.getOutputStream();
             fis=new FileInputStream(new File("yinyue.jpg"));
             byte[] buffer=new byte[1024];
             int len;
             while((len=fis.read(buffer))!=-1){
                 os.write(buffer,0,len);
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
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //服务端
    @Test
    public void server(){
        ServerSocket ss=null;
        Socket socket=null;
        InputStream is=null;
        FileOutputStream fos=null;
        try{
            ss=new ServerSocket(9999);
            socket=ss.accept();
            is=socket.getInputStream();
            fos=new FileOutputStream(new File("yinyue1.jpg"));
            //可以这样写，是因为这个文件本身是字节文件，能用字节流传输
            byte[] buffer=new byte[1024];
            int len;
            while((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(ss!=null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
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
