package test;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.junit.Test;
/*
早期JDK为我们提供了两种xml解析技术:DOM和Sax(已经过时，但我们需要知道这两种技术)
1.dom解析技术是W3C组织制定的，而所有的编程语言都对这个解析技术使用了自己语言的特点进行实现。Java对dom技术解析标记也做了实现
2.sun公司在JDK5版本对dom解析技术进行升级===>SAX(Simple API for XML)它跟W3C制定的解析不太一样。它是以类似事件机制通过
  回调告诉用户当前正在解析的内容。它是一行一行的读取xml文件进行解析的。不会创建大量的dom对象。所以它在解析xml的时候，
  在内存的使用和性能上都优于Dom解析。
3.第三方的解析:
3.1.jdom在dom基础上进行了封装
3.2.dom4j又对jdom进行了封装。
3.3.pull主要用在Android手机开发，是和sax非常类似都是事件机制解析xml文件
 */

//这个Dom4j它是第三方的解析技术。我们需要使用第三方给我们提供好的类库才可以解析xml文件。
public class Dom4jTest {
    @Test
    public void test1() throws Exception {
        //要创建一个Document对象，需要我们先创建一个SAXReader对象
        SAXReader saxReader = new SAXReader();
        //这个对象用于读取xml文件，然后返回一个Document。
        Document document = saxReader.read("src/books.xml");
        //打印到控制台，看看是否创建成功
        System.out.println(document);
    }

}
