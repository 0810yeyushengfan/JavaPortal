package test4;
/*
定义一个ComparableCircle类，继承Circle类并且实现CompareObject接口。
在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半径大小。
 */
public class ComparableCircle extends Circle implements CompareObject{
    public ComparableCircle() {
    }

    public ComparableCircle(double redius) {
        super(redius);
    }

    public int compareTo(Object o){
        if(this==o)
        {
            return 0;
        }
         if(o instanceof ComparableCircle)
        {
            ComparableCircle c=(ComparableCircle) o;
            //错误的方法:
            //return (int)(this.getRedius()-c.getRedius());
            //正确的:方法一:
            if(this.getRedius()>c.getRedius())
                return 1;
            else if(this.getRedius()==c.getRedius())
                return 0;
            else return -1;
            //正确的方法二:
            //当属性radius声明为Double包装类时，可以调用包装类的方法
            // return this.getRedius().compareTo(c.getRedius());
        }
         else
         {
             //return 0;不明确的
             throw new RuntimeException("传入的数据类型不匹配");
         }
    }

}
