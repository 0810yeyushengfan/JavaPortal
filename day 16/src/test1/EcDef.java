package test1;
//自定义异常类
public class EcDef extends Exception{
    static final long serialVersionUID=-930459949415L;
    public EcDef(){

    }
    public EcDef(String msg){
        super(msg);
    }
}
