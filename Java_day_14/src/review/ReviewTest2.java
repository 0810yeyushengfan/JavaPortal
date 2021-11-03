package review;

public class ReviewTest2 {
    public static void main(String[] args) {
        ReviewTest2 test2 =new ReviewTest2();
        int[] arr=new int[]{1,2,3};
        test2.print(arr);
        System.out.println(arr.getClass());
        System.out.println(arr.getClass().getSuperclass());

    }
    public void print(Object obj)
    {
        System.out.println(obj);
    }
}
