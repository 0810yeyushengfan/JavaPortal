package com.yeyu.springboot2_ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yeyu.springboot2_ssmp.pojo.Book;

public interface IBookService extends IService<Book> {
    //追加的操作与原始操作通过名称区分，功能类似
    boolean saveBook(Book book);

    boolean modify(Book book);

    boolean delete(Integer id);

    IPage<Book> getPage(int currentPage, int pageSize);

    //用于条件查询的自定义函数
    IPage<Book> getPage(Integer currentPage, Integer pageSize, Book queryBook);
}
