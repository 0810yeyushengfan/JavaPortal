package jiangjie1;
/*
每个函数默认的抛出的异常类型为RuntimeException，因为既然能运行到函数就说明通过了编译，如果有异常，
只能是运行时的异常，所以每个函数的默认抛出异常的类型都是运行时异常，即RuntimeException。
所以说如果在函数中调用了另一个抛出异常类型不是RuntimeException和它的子类的函数，或者是生成了一个
异常类型不是RuntimeException和它的子类的异常，此时需要显式的声明函数的抛出的异常类型为Exception或那另一个异常。
 */
public class ExceptionTest5 {
    public static void main(String[] args) {
        try{
            Student s=new Student();
            s.regist(-1001);
            System.out.println(s);
        }catch (Exception e){
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
class Student{
    private int id;
    public void regist(int id) throws Exception{
        if(id>0){
            this.id=0;
        }else{
            //System.out.println("输入的数据非法！");
            //手动抛出异常对象
            //throw new RuntimeException("您输入的数据非法！");//用它不需要显式声明函数的异常类型
            //throw new Exception("您输入的数据非法!");//用它需要显式声明函数的异常类型
            throw new MyException("不能输入负数!");//用它需要显式声明函数的异常类型
            //错误的:(只有异常类的对象才可以抛出）
            //throw new String("您输入的数据非法！")
        }
    }
}