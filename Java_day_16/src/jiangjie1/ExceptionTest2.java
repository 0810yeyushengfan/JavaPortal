package jiangjie1;
/*
一。异常的处理-----抓抛模型
过程一:"抛"：程序在正常执行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象，
                           并将此对象抛出。
                           一旦抛出对象以后，其后的代码就不再执行。
               关于异常对象的产生:
                 1.系统自动生成的异常类型
                 2.手动的生成一个异常对象，并抛出（throw）
过程二:"抓":可以理解为异常的处理方式:
                        1.try-catch-finally
                        2.throws
异常处理的方法一:try-catch-finally
二. try-catch-finally的使用
try{
          //可能出现异常的代码
}catch(异常类型1   变量名1){
          //处理异常的方式1
}catch(异常类型2  变量名2){
          //处理异常的方式2
}catch(异常类型3   变量名3){
          //处理异常的方式3
}
........................
fimally{
          //一定会·执行的代码
}
说明:
1.finally是可选的，不是必须选的。
2.使用try将可能出现异常的代码包装起来，在执行过程中，一旦出现异常，就会生成一个对应异常类的对象，
根据此对象的类型，去catch中进行匹配
3.一旦try中的异常对象匹配到某一个catch时，就进入catch中进行异常的处理，一旦处理完成，就跳出当前的
try-catch结构（在没有写finally的情况下），并继续执行其后的代码
4.catch中的异常类型如果没有子父类关系，则谁声明在上，谁声明在下无所谓。
   catch中的异常处理如果满足子父类关系，则要求子类一定声明在父类的上面，否则编译器会报错。
5.常用的异常处理的方式:
   5.1String getMessage():返回字符串信息(即在调用构造器中所传给构造器的字符串信息)
   5.2未被重写的toString():返回该异常类名和字符串信息(即调用getMessage()得到的信息)(或者直接输出该异常对象结果也是一样，因为实质也是调用toString()方法)
   5,3printStackTrace():打印该异常类名、字符串信息和方法调用到异常抛出的轨迹
   注：toString()和getMessage()和这2个方法的返回类型是String，是返回信息；
           而printStackTrace()的返回类型是void，是直接打印出信息
           三个方法的详细程度为:getMessage()<toString()<printStackTrace
6.在try结构中声明的变量，在出了try结构以后，就不能再被调用了(即使是在catch和finally中也不能调用)。
7.try-catch-finally结构可以嵌套(即可以在finally中再嵌套一层try-catch-finally)
体会1:使用try-catch-finally处理编译时异常，使得程序在编译时就不再报错，但是运行时仍可能报错，
            相当于我们使用try-catch-finally将一个编译时可能出现的异常，延迟到运行时出现。
体会2:开发中，由于运行时异常比较常见，所以我们通常就不针对运行时异常编写try-catch-finally了，
            针对于编译时异常，我们说一定要考虑异常的处理，不然根本无法运行，更何谈改写代码错误了。
 */
public class ExceptionTest2 {
    public static void main(String[] args) {
        String str="123";
        str="abc";
        int num=0;
        try{
            num=Integer.parseInt(str);//因为在这里出现了异常，所以下面的"hello-----1"没有被输出出来
            System.out.println("hello-----1");
        }catch(NumberFormatException e){
            //System.out.println("出现数值转换异常了，不要着急！");
            //toString();
            //System.out.println(e.toString());
            //System.out.println(e);
            //String getMessage();
            //System.out.println(e.getMessage());
            //printStackTrace();
            e.printStackTrace();
        }catch(NullPointerException e){
            //System.out.println("出现空指针异常了，不要着急！");
            e.printStackTrace();
        }catch (Exception e){
            //System.out.println("出现异常了，不要着急！");
            e.printStackTrace();
        }
        System.out.println(num);
        System.out.println("hello-----2");
    }
}
