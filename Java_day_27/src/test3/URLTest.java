package test3;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
URL网络编程
1.URL:统一资源定位符，它表示 Internet 上某一资源的地址
  注意:它是一种具体的URI，即URL可以用来标识一个资源，而且还指明了如何locate这个资源。
2.格式:
   http                   ://192.168.1.100 :8080             /helloworld/index.jsp#a               ?username=shkstart&password=123
   <传输协议>    ://<主机名>       :<端口号>    /<文件名>                    #片段名    ?参数列表
 */
public class URLTest {
    //URL网络编程实现Tomcat服务端数据下载
    public static void main(String[] args) {
        HttpURLConnection urlConnection=null;
        InputStream is=null;
        FileOutputStream fos=null;
        try{
            URL url=new URL("http://localhost:8080/examples/myTest.txt");
            urlConnection=(HttpURLConnection) url.openConnection();//获取url连接对象
            urlConnection.connect();//获取连接
            is=urlConnection.getInputStream();//造输入流
            fos=new FileOutputStream("day27\\yinyue3.jpg");
            //写入操作
            byte[] buffer=new byte[1024];
            int len;
            while((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            System.out.println("下载完成!");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭流资源
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
            if(urlConnection!=null){
                urlConnection.disconnect();
            }
        }
    }
    /*
一个URL对象生成后，其属性是不能被改变的，但可以通过它给定的方法来获取这些属性：
1.public String getProtocol( ) 获取该URL的协议名
2.public String getHost( ) 获取该URL的主机名
3.public String getPort( ) 获取该URL的端口号
4.public String getPath( ) 获取该URL的文件路径
5.public String getFile( ) 获取该URL的文件名
6.public String getQuery( ) 获取该URL的查询名
     */
    @Test
    public void test() throws MalformedURLException {
        URL url = new URL("http://localhost:8080/examples/myTest.txt");
        System.out.println("getProtocol() :"+url.getProtocol());
        System.out.println("getHost() :"+url.getHost());
        System.out.println("getPort() :"+url.getPort());
        System.out.println("getPath() :"+url.getPath());
        System.out.println("getFile() :"+url.getFile());
        System.out.println("getQuery() :"+url.getQuery());
    }
}
