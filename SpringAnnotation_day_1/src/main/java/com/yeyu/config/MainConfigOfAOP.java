package com.yeyu.config;

import com.yeyu.aop.LogAspect;
import com.yeyu.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*
AOP(动态代理):指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
步骤:
1.导入aop模块(spring-aspects)
2.定义一个业务逻辑类(MathCalculator):在业务逻辑运行的时候(方法之前、方法运行结束、方法出现异常，xxx)将日志进行打印
3.定义一个日志切面类(LogAspect):切面类里面的方法需要动态感知MathCalculator.div运行到哪里然后执行
4.给切面类的目标方法标注何时何地运行(通知注解)
通知注解:
前置通知(@Before):在目标方法运行之前执行
后置通知(@After):在目标方法运行结束之后执行(无论方法正常结束还是异常结束都会执行)
返回通知(@AfterReturning):在目标方法正常返回之后执行
异常通知(@AfterThrowing):在目标方法出现异常以后执行
环绕通知(@Around):动态代理，手动推进目标方法运行（joinPoint.procced()）
5.将切面类和业务逻辑类(目标方法所在类)都加入到容器中
6.必须告诉Spring哪个类是切面类(给切面类上加一个注解@Aspect)
7.给配置类中加@EnableAspectJAutoProxy注解，用于开启基于注解的AOP模式
总结的AOP三步走:
1.将业务逻辑组件和切面类都加入到IOC容器中，并用@Aspect注解告诉Spring哪个是切面类
2.在切面类上的每一个通知方法上标注通知注解，并用切入点表达式告诉Spring何时何地运行这些通知方法
3.在配置类上使用@EnableAspectJAutoProxy注解开启基于注解的aop模式
 */
//开启基于注解的aop模式
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {
    //业务逻辑类加入容器中
    @Bean
    public MathCalculator calculator() {
        return new MathCalculator();
    }

    //切面类加入到容器中
    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
