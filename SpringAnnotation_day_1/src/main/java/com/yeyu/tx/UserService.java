package com.yeyu.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public void insertUser() {
        userDao.insert();
        System.out.println("插入成功!");
        //模拟方法运行过程中有异常出现
        int i = 10 / 0;
        //其他的sql语句的执行
    }
}
