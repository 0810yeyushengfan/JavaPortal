package com.yeyu.mvc.controller;


import com.yeyu.mvc.bean.Employee;
import com.yeyu.mvc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
/*
功能清单:
功能               URL 地址         请求方式
访问首页            /               GET
查询全部数据         /employee       GET
删除               /employee/2     DELETE
跳转到添加数据页面    /toAdd          GET
执行保存            /employee       POST
跳转到更新数据页面    /employee/2     GET
执行更新            /employee       PUT
 */
@Controller
public class EmpolyeeController {

    //将employeeDao交给Spring容器进行管理，而不是自己创建
    @Autowired
    private EmployeeDao employeeDao;

    //具体功能:查询所有员工数据
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getEmployeeList(Model model){
        Collection<Employee> employeeList = employeeDao.getAll();
        model.addAttribute("employeeList", employeeList);
        return "employee_list";
    }

    //具体功能:删除
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }

    //具体功能:添加
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    //具体功能:跳转到更新数据页面并传递修改以前的原始数据
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("id")Integer id,Model model){
        Employee employee=employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    //具体功能:执行保存
    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }
}
