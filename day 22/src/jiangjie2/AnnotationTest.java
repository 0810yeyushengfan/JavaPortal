package jiangjie2;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/*
注解的使用
1.理解Annotation:
1.1.jdk5.0新增的功能
1.2.Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。
      通过使用 Annotation, 程序员可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。
      代码分析工具、开发工具和部署工具可以通过这些补充信息进行验证或者进行部署。
1.3.在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android中注解占据
      了更重要的角色，例如用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗代码和XML配置等。
2.Annocation的使用示例
   示例一:生成文档相关的注解
   示例二:在编译时进行格式检查(JDK内置的三个基本注解)
                  @Override: 限定重写父类方法, 该注解只能用于方法
                  @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
                  @SuppressWarnings: 抑制编译器警告
   示例三：跟踪代码依赖性，实现替代配置文件功能
3.如何自定义注解:参照@SuppressWarnings定义
   3.1.注解声明为:@interface
   3.2.内部定义成员:通常使用value表示
   3.3.可以指定成员的默认值，使用default定义
   3.4.如果自定义注解没有成员，表明是一个标识作用
   3.5.如果注解中有成员，在使用注解时需要指明成员的值
   3.6.自定义注解必须配上注解的信息处理流程(使用反射)才有意义
   3.7.自定义注解通常都会指明两个元注解:Retention,Target
4.jdk提供的4种元注解
   元注解:对现有的注解进行解释说明的注解
   Retention:指定所修饰的Annotation的生命周期:SOURCE/CLASS(默认行为)/RUNTIME
                       只有声明为RUNTIME生命周期的注解，才能通过反射获取。
    Target:用于指定被修饰的Annotation能用于修饰哪些程序元素
    **********************出现的频率较低***********************************************
    Documented:表示所修饰的注解在javadoc解析时能被保留下来
    Inherited:被它修饰的Annotation将具有继承性
5.通过反射获取注解信息----->到反射内容时系统讲解
6.jdk8中注解的新特性:可重复注解，类型注解
   6.1.可重复注解:
         6.1.1.在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
         6.1.2.并让MyAnnotation的元注解和MyAnnotations一致
   6.2.类型注解:
          6.2.1.ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）。
          6.2.2.ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。
 */
public class AnnotationTest {
    public static void main(String[] args) {

        Person person=new Person();
        Person student=new Student();
        student.walk();
//        student.eat1();
        Student student1=(Student) student;
        student1.eat1();

        @SuppressWarnings("unused")
        int a=10;
        @SuppressWarnings({"unused","rawtypes"})
        ArrayList arrayList=new ArrayList();


    }

    @Test
    public void testGetAnnotation(){
        Class clazz=Student.class;
        Annotation[] annotations=clazz.getAnnotations();
        for(int i=0;i<annotations.length;i++){
            System.out.println(annotations[i]);
        }
    }
}
