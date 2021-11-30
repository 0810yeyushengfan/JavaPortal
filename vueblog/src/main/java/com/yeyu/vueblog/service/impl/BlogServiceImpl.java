package com.yeyu.vueblog.service.impl;

import com.yeyu.vueblog.entity.Blog;
import com.yeyu.vueblog.mapper.BlogMapper;
import com.yeyu.vueblog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author anonymous
 * @since 2021-11-27
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
