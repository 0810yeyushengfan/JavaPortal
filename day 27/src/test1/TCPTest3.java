package test1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
/*
public void shutdownInput()如果在套接字上调用 shutdownInput() 后从套接字输入流读取内容，则流将
返回 EOF（文件结束符）。 即不能在从此套接字的输入流中接收任何数据。
 public void shutdownOutput()禁用此套接字的输出流。对于 TCP 套接字，任何以前写入的数据都将被发
送，并且后跟 TCP 的正常连接终止序列。 如果在套接字上调用 shutdownOutput() 后写入套接字输出流，
则该流将抛出 IOException。 即不能通过此套接字的输出流发送任何数据。
 */
/*
实现TCP的网络编程:
例子3:从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应的连接
 */
public class TCPTest3 {
    //客户端
    @Test
    public void client(){
        Socket socket=null;
        OutputStream os=null;
        FileInputStream fis=null;
        InputStream is=null;
        ByteArrayOutputStream baos=null;
        try {
            //1.准备Socket，连接服务器端   ，需要指定服务器端的IP地址和端口号
            socket=new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            //2.获取输出流，用来发送数据给服务器端
            os=socket.getOutputStream();
            //3.发送数据给服务器端
            fis=new FileInputStream(new File("yinyue.jpg"));
            byte[] buffer=new byte[1024];
            int len;
            while((len=fis.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
            os.flush();
            //4.关闭数据的输出
            //会在流末尾写入一个"流的末尾"标记，对方才能读到-1，使读取方法终止，否则对方打的读取方法会一直阻塞
            socket.shutdownOutput();
            //5.接收来自于服务器端的数据，并显示到控制台上
            is=socket.getInputStream();
             baos=new ByteArrayOutputStream();
             byte[] buffer1=new byte[20];
             int len1;
             while((len1=is.read(buffer1))!=-1){
                 baos.write(buffer1,0,len1);
             }
            System.out.println(baos.toString());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //6.关闭流资源
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭socket，不再与服务器端通信，即断开与服务器端的连接
            //socket关闭，意味着InputStream和OutputStream也关闭了
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
            if(baos!=null){
                try {
                    baos.close();
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
        }

    }

    //服务端
    @Test
    public void server(){
        ServerSocket ss=null;
        Socket socket=null;
        InputStream is=null;
        FileOutputStream fos=null;
        OutputStream os=null;
        try{
            //1.准备一个serverSocket
            ss=new ServerSocket(9999);
            //2.监听一个客户端的连接
            socket=ss.accept();//该方法是一个阻塞方法，若没有客户端连接服务端，则服务端一直保持等待
            System.out.println("一个客户端连接成功!");
            //3.获取输入流，用来接收客户端发送给服务器的数据
            is=socket.getInputStream();
            //4.接收客户端发送的数据
            //通信协议，即规则，现在相当于服务器端与客户端网络通信使用自己编写应用层通信协议
            //分为两步，第一步:服务器先收，直到读取到-1
            //那么意味着客户端需要先发送数据给服务器，并且在消息末尾加入"流末尾"的标记
            //第二步:服务器再发送数据给客户端
            //那么意味着客户端只能先发送数据才能收到服务器返回的内容
            //这个顺序也是属于通信的规则
            fos=new FileOutputStream(new File("yinyue2.jpg"));
            //可以这样写，是因为这个文件本身是字节文件，能用字节流传输
            byte[] buffer=new byte[1024];
            int len;
            while((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            //5.服务器端给予客户端反馈
            os=socket.getOutputStream();
            os.write("你好,图片我已收到!".getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //如果不再接收任何客户端的通信，可以关闭socketServer
            if(ss!=null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭socket，不再该客户端通信，即断开与这个客户端的连接
            //socket关闭，意味着InputStream和OutputStream也关闭了
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
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
