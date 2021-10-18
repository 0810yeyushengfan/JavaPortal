package service;

/**
 * 自定义异常类
 */
public class TeamExpection extends Exception {
   static final long servialVersionUID=904394195L;
   public TeamExpection(){
       super();
   }
   public TeamExpection(String msg){
       super(msg);
   }
}
