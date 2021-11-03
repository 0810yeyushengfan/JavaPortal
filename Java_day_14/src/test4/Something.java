package test4;

public class Something {
    public int addOne(final int x) {
        //return ++x;//编译报错，因为x本身变化了
        return x + 1;//能正常返回正确的值，因为x本身没有变
    } }
