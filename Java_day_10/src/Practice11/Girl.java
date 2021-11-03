package Practice11;

public class Girl {
    private String name;
    private int age;

    public Girl() {

    }

    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void marry(Boy boy) {
        System.out.println("我想嫁给" + boy.getName());
        boy.marry(this);
    }

    /**
     * @Description 比较两个对象的age属性的大小
     * @param girl
     * @return 正数，当前对象大。负数，当前对象小，0，当前对象和形参对象相等
     */
    public int compare(Girl girl)
    {
        return this.age-girl.age;
    }
}
