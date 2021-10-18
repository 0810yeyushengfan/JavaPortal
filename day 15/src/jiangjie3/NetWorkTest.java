package jiangjie3;

public class NetWorkTest {
    public static void main(String[] args) {
        ProxyServer proxyserver=new ProxyServer(new Server());
        proxyserver.browse();
    }
}

interface NetWork{
    public void browse();
}
//被代理类
class Server implements NetWork{
    public void browse(){
        System.out.println("真实的服务器访问网络");
    }
}
//代理类
class ProxyServer implements NetWork{
    private NetWork work;
    public ProxyServer(NetWork work){
        this.work=work;
    }
    public void check(){
        System.out.println("联网之前的检查工作");
    }
    public void browse(){
        check();
        work.browse();
    }
}