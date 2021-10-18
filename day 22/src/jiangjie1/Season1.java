package jiangjie1;
/*
使用enum关键字定义枚举类
说明:定义的枚举类默认继承于java.lang.Enum类中
 */
public enum Season1 implements Show{
    //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象用";"结束
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春");

        }
    },
    SUMMER("夏天","夏日炎炎") {
        @Override
        public void show() {
            System.out.println("夏");
        }
    },
    AUTUMN("秋天","秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋");
        }
    },
    WINTER("冬天","冰天雪地") {
        @Override
        public void show() {
            System.out.println("冬");
        }
    };

    //2.声明Season1对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器，并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.其他诉求:例如提供get()方法，重写toString()方法等
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
