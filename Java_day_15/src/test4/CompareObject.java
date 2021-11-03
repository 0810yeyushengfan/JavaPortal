package test4;
/*
定义一个接口用来实现两个对象的比较。
 */
interface CompareObject {
    //若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
    public int compareTo(Object o);
}