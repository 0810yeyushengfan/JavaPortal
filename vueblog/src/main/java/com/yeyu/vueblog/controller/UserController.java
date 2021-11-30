package com.yeyu.vueblog.controller;


import com.yeyu.vueblog.common.lang.Result;
import com.yeyu.vueblog.entity.User;
import com.yeyu.vueblog.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author anonymous
 * @since 2021-11-27
 */
@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;

    @RequiresAuthentication
    @GetMapping("/index")
    public Object index(){
        User byId = userService.getById(1);
        return Result.succ(byId);
    }


}
