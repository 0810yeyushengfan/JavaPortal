package jiangjie3;
/*
代理模式:
1.概述：代理模式是Java开发中使用较多的一种设计模式。代理设计就是为其他对象提供一种代理以控制对这个对象的访问。
2.应用场景：
   2.1安全代理：屏蔽对真实角色的直接访问。
   2.2远程代理：通过代理类处理远程方法调用（RMI）
   2.3延迟加载：先加载轻量级的代理对象，真正需要再加载真实对象比如你要开发一个大文档查看软件，大文档
   中有大的图片，有可能一个图片有100MB，在打开文件时，不可能将所有的图片都显示出来，这样就可以使用
   代理模式，当需要查看图片时，用proxy来进行大图片的打开。
3.分类
   3.1 静态代理（静态定义代理类）
   3.2动态代理（动态生成代理类）
   3.3JDK自带的动态代理，需要反射等知识
 */

public class StaticProxyTest {

    public static void main(String[] args) {
        Star s = new Proxy(new RealStar());//接口的多态
        s.confer();
        s.signContract();
        s.bookTicket();
        s.sing();
        s.collectMoney();
    }
}

interface Star {
    void confer();// 面谈

    void signContract();// 签合同

    void bookTicket();// 订票

    void sing();// 唱歌

    void collectMoney();// 收钱
}
//被代理类
class RealStar implements Star {

    public void confer() {
    }

    public void signContract() {
    }

    public void bookTicket() {
    }

    public void sing() {
        System.out.println("明星：歌唱~~~");
    }

    public void collectMoney() {
    }
}
//代理类
class Proxy implements Star {
    private Star real;

    public Proxy(Star real) {
        this.real = real;
    }

    public void confer() {
        System.out.println("经纪人面谈");
    }

    public void signContract() {
        System.out.println("经纪人签合同");
    }

    public void bookTicket() {
        System.out.println("经纪人订票");
    }

    public void sing() {
        real.sing();
    }

    public void collectMoney() {
        System.out.println("经纪人收钱");
    }
}
