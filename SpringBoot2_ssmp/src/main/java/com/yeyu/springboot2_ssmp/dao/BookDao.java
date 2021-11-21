package com.yeyu.springboot2_ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yeyu.springboot2_ssmp.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {
}
