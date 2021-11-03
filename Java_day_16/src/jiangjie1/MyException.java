package jiangjie1;
/*
一.在 Java 中你可以自定义异常。编写自己的异常类时需要记住下面的几点。
1.所有异常都必须是 Throwable 的子类。
2.如果希望写一个检查性异常类，则需要继承 Exception 类。
3.如果你想写一个运行时异常类，那么需要继承 RuntimeException 类。
二.如何自定义异常类?
1.继承于现有的异常结构:RuntimeException或Exception
2.提供全局变量:serialVerionUID
3.提供重载的构造器
 */
public class MyException extends RuntimeException {
    static final long serialVersionUID=-393949304049L;
    public MyException(){

    }
    public MyException(String msg){
        super(msg);
    }
}
