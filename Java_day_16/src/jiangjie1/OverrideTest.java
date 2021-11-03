package jiangjie1;
/*
方法重写的规则之一:
子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型
原因是必然会对最终的父类采用try-catch-finally处理异常，在处理异常的时候的catch结构中处理的是最终父类
抛出来的异常，而最终父类对子类有多态性，如果子类重写了父类的方法，在调用父类这个方法的时候，
由于多态性，此时是虚拟方法调用了子类的方法，一旦子类的方法抛出的异常类型大于父类被重写的方法
抛出的异常类型（也即是catch中所能处理的异常类型），此时try-catch-finally结构就不保证能够处理这个
抛出的异常，因此必须保证子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型，才能
保证这个异常一定能够被处理掉。
 */

import java.io.FileNotFoundException;
import java.io.IOException;

public class OverrideTest {
    public static void main(String[] args) {
        OverrideTest test=new OverrideTest();
        test.display(new SubClass());
    }
    public void display(SuperClass s){
        try{
            s.method();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
class SuperClass{
    public void method() throws IOException {

    }
}
class SubClass extends SuperClass{
    public void method() throws FileNotFoundException{

    }
}