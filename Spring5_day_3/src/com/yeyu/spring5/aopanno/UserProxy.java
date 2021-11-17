package com.yeyu.spring5.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
AOP的术语:
1.连接点:类里面的哪些方法可以被增强，这些方法称为连接到
2.切入点:实际被增强的方法，称为切入点
3.通知(增强):实际增强的逻辑部分称为通知(增强)，通知有多种类型:
3.1.前置通知:指在切入点执行之前执行的部分
3.2.后置通知:指在切入点执行之后执行的部分
3.3.环绕通知:指在切入点执行之前和之后都会执行一次的部分
3.4.异常通知:指在切入点执行中产生异常之后执行的部分
3.4.最终通知:也是在切入点执行之后执行的部分，与后置通知的区别就是最终通知不论切入点执行中是否产生异常，都一定会执行，
而后置通知在切入点执行中产生异常之后就不会在执行
4.切面:指把通知应用到切入点的过程
*/
/*
AOP操作的准备工作:
1.Spring框架一般都是基于AspectJ实现AOP操作:
AspectJ不是Spring的组成部分，是一个独立的AOP框架，一般把AspectJ和Spring框架一起使用，进行AOP操作
2.基于AspectJ实现AOP操作:
2.1.基于xml配置文件实现
2.2.基于注解方式实现(推荐使用)
3.在项目工程里面引入AOP的相关依赖
4.切入点表达式:
4.1.切入点表达式的作用:知道对哪个类里面的哪个方法进行增强
4.2.语法结构:
execution([权限修饰符] [返回类型] [类全路径] [方法名称]([参数列表]))
权限修饰符可以省略
在参数列表中用..表示任意参数
在其他地方用*表示所有
举例1:对com.yeyu.dao.BookDao类里面的add()方法进行增强
execution(* com.yeyu.dao.BookDao.add(..))
举例2:对com.yeyu.dao.BookDao类里面的所有的方法进行增强
execution(* com.yeyu.dao.BookDao.* (..))
举例3:对com.yeyu.dao包里面所有的类里面的所有的方法进行增强
execution(* com.yeyu.dao.*.* (..))
 */
//增强的类
@Component
//@Aspect:生成代理对象
@Aspect
@Order(3)
public class UserProxy {

    //@Pointcut:相同切入点的抽取
    //value属性中同样填写切入点表达式，填写完以后，如果有其他方法也想用这个切入点，就可以直接在通知注解的value属性值里面填写@Pointcut注解的方法名
    @Pointcut(value = "execution(* com.yeyu.spring5.aopanno.User.add(..))")
    public void pointdemo() {
        //在这个方法里面写的内容没有任何作用
        System.out.println("1");
    }

    //@Before:前置通知
    //value属性中填写切入点表达式，以确定这个通知是用来增强哪个方法的，也可以填写用@Pointcut注解的方法名
    @Before(value = "pointdemo()")
    public void before() {
        System.out.println("before.........");
    }

    //@AfterReturning:后置通知(返回通知)
    @AfterReturning(value = "execution(* com.yeyu.spring5.aopanno.User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning.........");
    }

    //@After:最终通知
    @After(value = "execution(* com.yeyu.spring5.aopanno.User.add(..))")
    public void after() {
        System.out.println("after.........");
    }

    //@AfterThrowing:异常通知
    @AfterThrowing(value = "execution(* com.yeyu.spring5.aopanno.User.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing.........");
    }

    //@Around:环绕通知
    @Around(value = "execution(* com.yeyu.spring5.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前.........");
        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后.........");
    }
}
