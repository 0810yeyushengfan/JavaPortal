package jiangjie2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//Properties:时Hashtable的子类，常用来处理配置文件，key和value都是String类型的
public class PropertiesTest {
    public static void main(String[] args)  {
        FileInputStream fileInputStream=null;
        try {
            Properties properties=new Properties();
            fileInputStream=new FileInputStream("Peizhi.properties");
            properties.load(fileInputStream);//加载流对应的文件
            String name=properties.getProperty("name");
            String age=properties.getProperty("age");
            System.out.println("name="+name+", age="+ age);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fileInputStream!=null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
