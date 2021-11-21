package com.yeyu.springboot2_ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeyu.springboot2_ssmp.dao.BookDao;
import com.yeyu.springboot2_ssmp.pojo.Book;
import com.yeyu.springboot2_ssmp.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
    @Autowired
    public BookDao bookDao;

    @Override
    public boolean saveBook(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public boolean modify(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        bookDao.selectPage(page, null);
        return page;
    }

    public IPage<Book> getPage(Integer currentPage, Integer pageSize, Book queryBook) {
        IPage page = new Page(currentPage, pageSize);
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        //使用模糊查询以达到条件查询的效果
        lqw.like(Strings.isNotEmpty(queryBook.getName()), Book::getName, queryBook.getName());
        lqw.like(Strings.isNotEmpty(queryBook.getType()), Book::getType, queryBook.getType());
        lqw.like(Strings.isNotEmpty(queryBook.getDescription()),
                Book::getDescription, queryBook.getDescription());
        return bookDao.selectPage(page, lqw);
    }
}
