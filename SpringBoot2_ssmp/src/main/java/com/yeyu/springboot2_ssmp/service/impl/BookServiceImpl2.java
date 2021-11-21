package com.yeyu.springboot2_ssmp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yeyu.springboot2_ssmp.dao.BookDao;
import com.yeyu.springboot2_ssmp.pojo.Book;
import com.yeyu.springboot2_ssmp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl2 implements BookService {
    @Autowired
    private BookDao bookDao;

    //因为bookDao.insert(book)返回的是这个插入操作影响的行数
    //而我们在BookService规定的save()方法的返回值含义是这次操作是否成功
    //bookDao.insert(book)的返回值大于0代表插入操作影响的行数大于0行，也就是这次操作成功了
    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getByPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        return bookDao.selectPage(page, null);
    }
}
