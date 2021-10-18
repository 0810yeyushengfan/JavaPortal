package jiangjie3;
/*
main作为与控制台交互的一种方式
 */
public class MainDemo {
    public static void main(String[] args) {
        for(int i=0;i<args.length;i++)
        {
            System.out.println("****"+args[i]);
            int num=Integer.parseInt(args[i]);
            System.out.println("####"+num+1);
        }

    }
}
