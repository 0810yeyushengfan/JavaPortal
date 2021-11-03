package jiangjie3;

import java.io.IOException;
import java.net.InetAddress;

/*
一.网络编程中有两个主要的问题:
1.如何准确地定位网络上一台或者多台主机并定位主机上的特定应用。
2.找到主机后如何可靠高效地进行数据传输
二.网络编程中的两个要素:
1.对应问题一:IP和端口号
2.对应问题二:提供网络通信协议:TCP/IP参考模型(应用层，传输层，网络层，物理+数据链路层)
三.通信要素一:IP和端口号
1.IP:唯一的标识Internet上的计算机(通信实体)
2.在java中使用InetAddress类代表IP
3.IP分类:IPV4和IPV6
                 万维网和局域网
4.域名:www.baidu.com    www.mi.com    www.sina.com    www.jd.com    www.vip.com
   域名容易记忆，当在连接网络时输入一个主机的域名后，域名服务器(DNS)负责将域名转化成IP地址，
   这样才能和主机建立连接。 -------域名解析
5.本地回路地址:127.0.0.1对应着:Localhost
    192.168.开头的就是私有址址，范围即为192.168.0.0--192.168.255.255，专门为组织机构内部使用
6.如何实例化InetAddress:两个方法:getByName(String host)   getLocalHost()(得到本地的InetAddress)
   注意:InetAddress类没有提供公共的构造器，
   两个常用方法:getHostName()(获取此 IP 地址的主机名)/getHostAddress()(返回 IP 地址字符串（以文本表现形式）)
7.端口号:正在计算机上运行的进程
   要求:不同的进程有不同的端口号
   范围:被规定为一个16位的整数 0~65535
8.端口号与IP地址的组合得出一个网络套接字:Socket利用套接字(Socket)开发网络应用程序早已被广泛的采用，
   以至于成为事实上的标准。
   8.1.网络上具有唯一标识的IP地址和端口号组合在一起才能构成唯一能识别的标识符套接字。
   8.2.通信的两端都要有Socket，是两台机器间通信的端点。
   8.3.网络通信其实就是Socket间的通信。
   8.4. Socket允许程序把网络连接当成一个流，数据在两个Socket间通过IO传输。
   8.5 .一般主动发起通信的应用程序属客户端，等待通信请求的为服务端。
   8.6.Socket分类：
   流套接字（stream socket）：使用TCP提供可依赖的字节流服务
   数据报套接字（datagram socket）：使用UDP提供“尽力而为”的数据报服务
 */
public class InedAddressTest {
    public static void main(String[] args) {
        try{
            InetAddress inet1=InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);
            InetAddress inet2=InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);
            InetAddress inet3=InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
