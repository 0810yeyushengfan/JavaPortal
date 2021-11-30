package com.yeyu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

//标注该类为切面类
@Aspect
public class LogAspect {
    //抽取公共的切入点表达式
    //1.本类引用该切入点表达式直接使用方法名
    //2.其他的切面引用该切入点表达式需要使用方法所在类的全类名加上该方法名
    @Pointcut("execution(public int com.yeyu.aop.MathCalculator.*(..))")
    public void pointCut() {
    };

    //@Before在目标方法之前切入
    //切入点表达式(指定在哪个方法切入)
    @Before("pointCut()")
    //JoinPoint对象在参数列表中时，会自动从IOC容器中获取该切入点方法并赋值，不需要配置其他注解
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("" + joinPoint.getSignature().getName() + "运行，@Before:参数列表是:{" + Arrays.asList(args) + "}");
    }

    @After("com.yeyu.aop.LogAspect.pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println("" + joinPoint.getSignature().getName() + "结束，@After");
    }

    //JoinPoint一定要出现在参数表的第一位，否则在IOC容器中获取不到，会报错
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("" + joinPoint.getSignature().getName() + "正常返回，@AfterReturning:运行结果：{" + result + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println("" + joinPoint.getSignature().getName() + "异常，异常信息：{" + exception + "}");
    }
}
