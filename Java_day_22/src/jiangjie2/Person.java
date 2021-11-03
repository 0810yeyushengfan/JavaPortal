package jiangjie2;

//希望实现的可重复注解效果
//@MyAnnotation(value="hi")
//@MyAnnotation("hello")

///jdk8之前的可重复注解写法
//@MyAnnotations({@MyAnnotation(value="hi"),@MyAnnotation("hello")})

import java.util.ArrayList;

///jdk8之后的可重复注解写法
@MyAnnotation(value="hi")
@MyAnnotation("hello")

public class Person {
    private String name;
    private int age;

    @MyAnnotation
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void eat(){
        System.out.println("人吃饭");
    }
    public void walk(){
        System.out.println("人走路");
    }
}
interface Info{
    void show();
}
class Student extends Person implements Info{
    @Override
    public void walk(){
        System.out.println("学生走路");
    }
//    @Override//会进行校验是否是重写方法，不是父类的重写方法会在编译前报错
//    public void eAt(){
//        System.out.println("学生吃饭");
//    }
    //不加就不会校验，不是重写方法就是新建的一个方法
    public void eat1(){
        System.out.println("学生吃饭");
    }
    @Override
    public void show() {

    }
}

class Generic<@MyAnnotation T>{
    public static void main(String[] args) throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list=new ArrayList<>();
        int num=(@MyAnnotation int)10L;
    }
}