package jiangjie1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest3 {
    public static void main(String[] args) {
        try {
            File file = new File("hello.text");
            FileInputStream fis = new FileInputStream(file);
            int date = fis.read();
            while (date != -1) {
                System.out.println((char) date);
                date = fis.read();
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
