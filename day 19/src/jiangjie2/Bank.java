package jiangjie2;

/*

 */
public class Bank {
    private Bank() {

    }

    private static Bank instance = null;
    //方式一:效率稍差
//    public static synchronized Bank getInstance(){
//        if(instance==null){
//            instance =new Bank();
//        }else{
//            return instance;
//        }
//    }
    //方式二:
    public static Bank getInstance(){
        if(instance==null){
            synchronized (Bank.class){
                if(instance==null){
                    instance=new Bank();
                }
            }
        }
        return instance;
    }
}
