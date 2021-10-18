package test6;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    @Test
    public void test(){
        File file=new File("E:\\java\\shiyan\\shiyan1\\shiyan4");
        //创建一个与file同目录下的另外一个文件，文件名为:haha.txt
        File destFile=new File(file.getParent(),"haha.txt");
        boolean newFile=false;
        try {
            newFile=destFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(newFile){
            System.out.println("创建成功!");
        }
    }
}
