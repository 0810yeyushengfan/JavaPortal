package com.yeyu.springboot2_day_3;

import com.yeyu.springboot2_day_3.dao.BookDao;
import com.yeyu.springboot2_day_3.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot2Day3ApplicationTests {
    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        Book book = bookDao.getById(5);
        System.out.println(book);
    }
}
