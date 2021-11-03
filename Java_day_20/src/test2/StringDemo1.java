package test2;

import org.junit.Test;

/*
将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
 */
public class StringDemo1 {
    //方式一:转换为char[]
    public String reverse1(String str,int startIndex,int endIndex){
        if(str!=null&&str.length()!=0) {
            char[] arr = str.toCharArray();
            for(int x=startIndex,y=endIndex;x<y;x++,y--){
                char temp=arr[x];
                arr[x]=arr[y];
                arr[y]=temp;
            }
            return new String(arr);
        }
        return null;
    }

    //方式二:使用String的拼接
    public String reverse2(String str,int startIndex,int endIndex){
        if(str!=null){
            //第一部分
            String reverseStr=str.substring(0,startIndex);
            //第二部分
            for(int i=endIndex;i>=startIndex;i--){
                reverseStr+=str.charAt(i);
            }
            //第三部分
            reverseStr+=str.substring(endIndex+1);
            return reverseStr;
        }
        return null;
    }

    //方式三:使用StringBuffer/StringBuilder替换String
    public String reverse3(String str,int startIndex,int endIndex){
        StringBuilder builder=new StringBuilder(str.length());
        //第一部分
        builder.append(str.substring(0,startIndex));
        //第二部分
        for(int i=endIndex;i>=startIndex;i--){
            builder.append(str.charAt(i));
        }
        //第三部分
        builder.append(str.substring(endIndex+1));
        return builder.toString();

    }
    @Test
    public void test1(){
        String str="abcdefg";
        String reverse1=reverse1(str,2,5);
        System.out.println(str);
        System.out.println(reverse1);
    }

    @Test
    public void test2(){
        String str="abcdefg";
        String reverse2=reverse2(str,2,5);
        System.out.println(str);
        System.out.println(reverse2);
    }
    @Test
    public void test3(){
        String str="abcdefg";
        String reverse3=reverse3(str,2,5);
        System.out.println(str);
        System.out.println(reverse3);
    }

}
