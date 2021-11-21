package com.yeyu.springboot2_ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yeyu.springboot2_ssmp.controller.utils.R;
import com.yeyu.springboot2_ssmp.pojo.Book;
import com.yeyu.springboot2_ssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    //注意:查询操作全部都没有考虑查询过程中失败出现异常的情况(前后端都没有考虑)
    @GetMapping
    public R getAll() {
        List<Book> bookList = bookService.list();
        return new R(true, bookList);
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        //手动模拟插入数据操作中出现异常，以便进行测试
        if (book.getName().equals("exception!!!"))
            throw new IOException();
        Boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody Book book) throws IOException{
        //手动模拟修改数据操作中出现异常，以便进行测试
        if (book.getName().equals("exception!!!"))
            throw new IOException();
        boolean flag = bookService.modify(book);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) throws IOException{

        boolean flag = bookService.delete(id);
        return new R(flag, flag ? "删除成功^_^" : "删除失败-_-!");
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        return new R(true, book);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getAll(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), pageSize, book);
        }
        return new R(true, page);
    }
}
