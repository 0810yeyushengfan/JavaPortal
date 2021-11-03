package jiangjie1;

public class Season1Test {
    public static void main(String[] args) {
        Season1 summer=Season1.SUMMER;
        System.out.println(summer);
        //toString():返回枚举类对象的名称
        System.out.println(summer.toString());
        //System.out.println(Season1.class.getSuperclass());//class java.lang.Enum
        System.out.println("******************************");

        //values():返回所有的枚举类对象构成的数组
        Season1[] values=Season1.values();
        for(int i=0;i<values.length;i++){
            System.out.println(values[i]);
            values[i].show();
        }
        Thread.State[] states= Thread.State.values();//名为State的枚举类在Thread类中
        for(int i=0;i<states.length;i++){
            System.out.println(states[i]);
        }
        //valueOf(String objName):返回枚举类中对象名时objName的对象
        //如果没有对象名时objName的对象则抛ILLeagalArgumentException
        // Season1 winter=Season1.valueOf("WINTR" );
        Season1 winter=Season1.valueOf("WINTER" );
        System.out.println(winter);


    }
}
