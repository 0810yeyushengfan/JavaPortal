package com.yeyu.springboot2_day_1;

import com.yeyu.springboot2_day_1.Service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot2Day1ApplicationTests {
    @Autowired
    private BookService bookService;
    @Test
    void contextLoads() {
        bookService.test();
    }
}
