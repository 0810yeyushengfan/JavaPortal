package test5;

class Something {
    public static void main(String[] args) {
        Other o = new Other();
        new Something().addOne(o);
    }
    public void addOne(final Other o) {
        // o = new Other();//编译报错，因为o已经被final修饰，所以不能再new一个新的o了。
        o.i++;//虽然不能对o本身进行修改，但是能对o包含的属性进行修改。
    }
}
class Other {
    public int i;
}