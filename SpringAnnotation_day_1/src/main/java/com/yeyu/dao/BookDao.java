package com.yeyu.dao;

import org.springframework.stereotype.Component;

//在IOC容器中生成的Bean的id默认是类名首字母小写
@Component
public class BookDao {
    //用来验证@Autowired是不是在找到多个相同类型的组件的时候，将属性的名称作为组件的id去IOC容器中查找
    private int lable=1;

    @Override
    public String toString() {
        return "BookDao{" +
                "lable=" + lable +
                '}';
    }

    public int getLable() {
        return lable;
    }

    public void setLable(int lable) {
        this.lable = lable;
    }
}
