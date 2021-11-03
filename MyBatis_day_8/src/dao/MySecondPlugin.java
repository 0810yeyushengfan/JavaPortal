package dao;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

//多个插件同时拦截同一个对象的同一个方法，插件的执行顺序取决于mybatis-config.xml中<plugin>配置的顺序，
//靠前面的会先进行包装(plugin())，靠后面的会先进行拦截(intercept())
//不同拦截对象的执行顺序是Executor->StatementHandler->ParameterHandler->ResultSetHandler

//完成插件签名，告诉MyBatis当前插件用来拦截哪个对象的哪个方法
@Intercepts(
        {
                @Signature(type= StatementHandler.class,method = "parameterize",args = java.sql.Statement.class)
        }
)
public class MySecondPlugin implements Interceptor {

    //拦截目标对象的目标方法的执行
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //执行目标方法
        System.out.println("MySecondPlugin...intercept:"+invocation.getMethod());
        Object proceed = invocation.proceed();
        //返回执行后的返回值
        return proceed;
    }

    //包装目标对象，为目标对象创建一个代理对象
    @Override
    public Object plugin(Object target) {
        //我们可以借助Plugin的wrap方法来使用当前Interceptor包装我们的目标对象
        System.out.println("MySecondPlugin...plugin:mybatis建立的代理对象是"+target);
        Object wrap = Plugin.wrap(target, this);
        //返回为当前target创建的动态代理
        return wrap;
    }


    //将插件在全局配置文件中注册时的property属性设置进来
    @Override
    public void setProperties(Properties properties) {
        System.out.println("MySecondPlugin...插件配置的信息:"+properties);
    }
}
