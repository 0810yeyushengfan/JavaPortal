import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
/*
1.AOP底层使用动态代理，有两种情况动态代理:
1.1.有接口的情况:使用JDK动态代理，创建接口实现类代理对象，增强类的方法
1.2.没有接口的情况:使用CGLIB动态代理，创建子类的代理对象，增强类的方法
 */

//编写JDK动态代理的代码
//3.使用Proxy类创建接口代理对象
public class JDKProxy {

    public static void main(String[] args) {
        //创建接口实现类代理对象
        //调用Proxy.newProxyInstance()方法
        //方法有三个参数:
        //第一个参数:类加载器
        //第二个参数:增强方法所在的类实现的接口，支持多个接口
        //第三个参数:实现接口InvocationHandler，创建代理对象，在这里写增强的部分
        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int result = dao.add(1, 2);
        System.out.println("result:" + result);
    }
}

//创建代理对象代码
class UserDaoProxy implements InvocationHandler {
    //有参数构造传递把被代理对象传递进来
    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //被增强的方法执行之前
        System.out.println("方法之前执行...." + method.getName() + " :传递的参数..." + Arrays.toString(args));
        //被增强的方法执行
        Object res = method.invoke(obj, args);
        //被增强的方法执行之后
        System.out.println("方法之后执行...." + obj);
        return res;
    }
}
