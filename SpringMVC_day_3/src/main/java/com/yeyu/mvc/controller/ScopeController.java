package com.yeyu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {
    //1.使用ServletAPI向request域对象共享数据
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServlet(HttpServletRequest request) {
        request.setAttribute("testRequestScope", "hello,servletAPI");
        return "success";
    }

    /*
    Model、ModelMap、Map的关系:
    Model、ModelMap、Map类型的参数其实本质上都是BindingAwareModelMap类型的:
    1.public interface Model{}
    2.public class ModelMap extends LinkedHashMap<String, Object> {}
    3.public class ExtendedModelMap extends ModelMap implements Model {}
    4.public class BindingAwareModelMap extends ExtendedModelMap {}
     */
    //2.使用ModelAndView向request域对象共享数据
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        /*
         ModelAndView有Model和View的功能:
         1.Model主要用于向请求域共享数据
         2.View主要用于设置视图，实现页面跳转
         */
        ModelAndView modelAndView = new ModelAndView();
        //向请求域共享数据
        modelAndView.addObject("testRequestScope", "hello,ModelAndView");
        //设置视图，实现页面跳转
        modelAndView.setViewName("success");
        //必须返回ModelAndView对象
        return modelAndView;
    }

    //3.使用Model向request域对象共享数据
    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope", "hello,model");
        System.out.println(model.getClass().getName());
        return "success";
    }

    //4.使用map向request域对象共享数据
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("testRequestScope", "hello,map");
        System.out.println(map.getClass().getName());
        return "success";
    }


    //5.使用ModelMap向request域对象共享数据
    @RequestMapping("testModelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testRequestScope", "hello,ModelMap");
        System.out.println(modelMap.getClass().getName());
        return "success";
    }

    //6.向session域共享数据
    @RequestMapping("testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope", "hello,Session");
        return "success";
    }

    //7.向application域共享数据
    @RequestMapping("testApplication")
    public String testApplication(HttpSession session) {
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope", "hello,Application");
        return "success";

    }
}

