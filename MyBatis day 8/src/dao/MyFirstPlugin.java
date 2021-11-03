package dao;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.util.Properties;
//完成插件签名，告诉MyBatis当前插件用来拦截哪个对象的哪个方法
@Intercepts(
        {
                @Signature(type= StatementHandler.class,method = "parameterize",args = java.sql.Statement.class)
        }
)
public class MyFirstPlugin implements Interceptor {

    //拦截目标对象的目标方法的执行
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //执行目标方法
        System.out.println("MyFirstPlugin...intercept:"+invocation.getMethod());
        //动态的改变一下sql运行的参数，做到查1号员工时，实际上是从数据库中查询3号员工
        Object target=invocation.getTarget();
        System.out.println("当前拦截到的对象:"+target);
        //拿到target的元数据
        MetaObject metaObject = SystemMetaObject.forObject(target);
        //拿到StatementHandler===>ParameterHandler===>parameterObject
        Object value=metaObject.getValue("parameterHandler.parameterObject");
        System.out.println("sql语句用的参数是:"+value);
        //修改sql语句要用的参数
        metaObject.setValue("parameterHandler.parameterObject",(Integer)value+2);
        //执行目标方法
        Object proceed = invocation.proceed();
        //返回执行后的返回值
        return proceed;
    }

    //包装目标对象，为目标对象创建一个代理对象
    @Override
    public Object plugin(Object target) {
        //我们可以借助Plugin的wrap方法来使用当前Interceptor包装我们的目标对象
        System.out.println("MyFirstPlugin...plugin:mybatis建立的代理对象是"+target);
        Object wrap = Plugin.wrap(target, this);
        //返回为当前target创建的动态代理
        return wrap;
    }


    //将插件在全局配置文件中注册时的property属性设置进来
    @Override
    public void setProperties(Properties properties) {
        System.out.println("MyFirstPlugin...插件配置的信息为:"+properties);
    }
}
