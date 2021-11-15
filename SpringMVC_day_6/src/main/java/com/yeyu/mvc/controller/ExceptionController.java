package com.yeyu.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//2.基于注解的异常处理
//@ControllerAdvice将当前类标识为异常处理的组件(这个也会将当前类通过@Controller注解将其标识为一个控制层组件，交给Spring的IoC容器管理，此时SpringMVC才能够识别控制器的存在)
@ControllerAdvice
public class ExceptionController {

    //@ExceptionHandler用于设置所标识方法处理的异常,value是一个放异常类型的数组
    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
    public String testException(Exception ex, Model model){
        //ex表示当前请求处理中出现的异常对象
        model.addAttribute("ex", ex);
        return "error";
    }

}
