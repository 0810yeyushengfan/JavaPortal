package com.yeyu.springboot2_ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yeyu.springboot2_ssmp.pojo.Book;

import java.util.List;

public interface BookService {
    //返回值是这次操作是否成功
    Boolean save(Book book);

    Boolean update(Book book);

    Boolean delete(Integer id);

    Book getById(Integer id);

    List<Book> getAll();

    IPage<Book> getByPage(int currentPage, int pageSize);


}
