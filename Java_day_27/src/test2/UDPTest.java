package test2;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
//先启动接收端再启动发送端
public class UDPTest {
    //发送端
    @Test
    public void sender(){
        DatagramSocket socket=null;
        try{
            socket=new DatagramSocket();
            String str="我是UDP方式发送的垃圾短信";
            byte[] data=str.getBytes();
            InetAddress inet=InetAddress.getLocalHost();
            DatagramPacket packet=new DatagramPacket(data,0,data.length,inet,9999);
            socket.send(packet);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(socket!=null){
                socket.close();
            }
        }
    }
    //接收端
    @Test
    public void receiver(){

        DatagramSocket socket=null;
        try{
            //在接收端，要指定监听的端口。
            socket=new DatagramSocket(9999);
            byte[] buffer=new byte[100];
            DatagramPacket packet=new DatagramPacket(buffer,0,buffer.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData(),0,packet.getLength()));
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(socket!=null){
                socket.close();
            }
        }
    }
}
