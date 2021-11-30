package com.yeyu.service;

import com.yeyu.dao.BookDao;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class BookService {
    @Inject
    public BookDao bookDao;
    public void print(){
        System.out.println(bookDao);
    }
}
