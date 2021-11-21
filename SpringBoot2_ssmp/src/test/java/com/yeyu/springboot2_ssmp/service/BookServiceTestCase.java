package com.yeyu.springboot2_ssmp.service;

import com.yeyu.springboot2_ssmp.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private BookService bookService;

    @Test
    public void testGetById(){
        System.out.println(bookService.getById(9));
    }

    @Test
    public void testGetAll(){
        System.out.println(bookService.getAll());
    }

    @Test
    public void testGetByPage(){
        System.out.println(bookService.getByPage(1,5).getRecords());
    }

    @Test
    public void testSave(){
        Book book = new Book();
        book.setType("测试类型1");
        book.setName("测试名字1");
        book.setDescription("测试描述1");
        bookService.save(book);
    }

    @Test
    public void testDelete(){
        bookService.delete(9);
    }

    @Test
    public void testUpdate(){
        Book book = new Book();
        book.setId(2);
        book.setName("测试名字2");
        book.setType("测试类型2");
        book.setDescription("测试描述2");
        bookService.update(book);
    }
}
