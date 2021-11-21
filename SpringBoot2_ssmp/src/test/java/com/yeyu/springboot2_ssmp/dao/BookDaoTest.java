package com.yeyu.springboot2_ssmp.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yeyu.springboot2_ssmp.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTest {
    @Autowired
    public BookDao bookDao;
    @Test
    public void testInsert(){
        Book book = new Book();
        book.setType("测试类型1");
        book.setName("测试名字1");
        book.setDescription("测试描述1");
        bookDao.insert(book);
    }

    @Test
    public void testDelete(){
        bookDao.deleteById(4);
    }

    @Test
    public void testUpdate(){
        Book book = new Book();
        book.setId(5);
        book.setName("测试名字2");
        book.setType("测试类型2");
        book.setDescription("测试描述2");
        bookDao.updateById(book);
    }

    @Test
    public void testSelectById(){
        System.out.println(bookDao.selectById("6"));
    }

    @Test
    public void testSelectAll(){
        System.out.println(bookDao.selectList(null));
    }

    @Test
    public void testSelectPage(){
        //意思是从第一行数据开始，总计5行数据
        IPage page =new Page(1,5);
        IPage iPage = bookDao.selectPage(page, null);
        System.out.println(iPage.getRecords());
    }

    @Test
    public void testSelectByCondition(){
        //模拟没有从前端获取到数据
        String name =null;
        LambdaQueryWrapper<Book> lambdaQueryWrapper=new LambdaQueryWrapper<Book>();
        lambdaQueryWrapper.like(Book::getName,name);
        System.out.println(bookDao.selectList(lambdaQueryWrapper));
    }
}
