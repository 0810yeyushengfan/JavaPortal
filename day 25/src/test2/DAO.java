package test2;

import java.util.List;

public class DAO<T> {//表的共性操作
    //添加一条记录
    public void add(T t){

    }
    //删除一条记录
    public boolean remove(int index){
        return false;
    }
    //修改一条记录
    public void update(int index,T t){

    }
    //查询一条记录
    public T getIndex(int index){
        return null;
    }
    //查询多条记录
    public List<T> getForlist(int index){
        return null;
    }
    //泛型方法
    //举例：获取表中一共有多少条记录？获取最大的员工入职时间？
    public <E> E getValue(){//此E和泛型类DAO的T无关，即泛型方法和所在的类是不是泛型类无关

        return null;
    }
}
