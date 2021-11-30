package com.yeyu.vueblog.service.impl;

import com.yeyu.vueblog.entity.User;
import com.yeyu.vueblog.mapper.UserMapper;
import com.yeyu.vueblog.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
