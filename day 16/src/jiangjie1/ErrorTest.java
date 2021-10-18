package jiangjie1;
/*
Error:
java虚拟机无法解决的严重问题，比如JVM系统内部错误，资源耗尽等严重情况，比如:stackOverflowError和OutOfMemoryError。
一般不编写针对性的代码进行处理。
 */
public class ErrorTest {
    public static void main(String[] args) {
        //1.栈溢出:java.lang.StackOverflowError
        main(args);
        //2.堆溢出:java.lang.OutOfMemoryError
        Integer[] arr=new Integer[1024*1024*1024];
    }
}
