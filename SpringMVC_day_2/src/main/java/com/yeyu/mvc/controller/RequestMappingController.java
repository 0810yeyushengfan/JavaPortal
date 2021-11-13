package com.yeyu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@RequestMapping注解
@Controller
//@RequestMapping标识一个类：设置映射请求的请求路径的初始信息
//此时请求映射所映射的请求的请求路径为:/hello/xxx
//@RequestMapping("/hello")
public class RequestMappingController {

    //@RequestMapping标识一个方法:设置映射请求请求路径的具体信息
    @RequestMapping("/")
    public String index() {
        //设置视图名称
        return "index";
    }

    /*
    1.@RequestMapping注解的value属性:
    1.1.@RequestMapping注解的value属性通过请求的请求地址匹配请求映射
    1.2.@RequestMapping注解的value属性是一个字符串类型的数组，表示该请求映射能够匹配多个请求地址所对应的请求
    1.3.@RequestMapping注解的value属性必须设置，至少通过请求地址匹配请求映射
     */
    /*
    2.@RequestMapping注解的method属性
    2.1.@RequestMapping注解的method属性通过请求的请求方式(get或post)匹配请求映射
    2.2.@RequestMapping注解的method属性是一个RequestMethod类型的数组，表示该请求映射能够匹配多种请求方式的请求
    2.3.若当前请求的请求地址满足请求映射的value属性，但是请求方式不满足method属性，则浏览器报错405:Request method 'POST' not supported
     */
    @RequestMapping(
            value = {"/testRequestMapping", "/test"},
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String testRequestMapping() {
        return "success";
    }

    /*
  注意:
  1:对于处理指定请求方式的控制器方法，SpringMVC中提供了@RequestMapping的派生注解:
  1.1.处理get请求的映射-->@GetMapping
  1.2.处理post请求的映射-->@PostMapping
  1.3.处理put请求的映射-->@PutMapping
  1.4.处理delete请求的映射-->@DeleteMapping
  2.常用的请求方式有get，post，put，delete，但是目前浏览器只支持get和post，若在form表单提交时，为method设置了其他
  请求方式的字符串（put或delete），则按照默认的请求方式get处理若要发送put和delete请求，则需要通过spring提供的过滤器
  HiddenHttpMethodFilter，在RESTful部分会讲到
   */
    @GetMapping("/testGetMapping")
    public String testGetMapping() {
        return "success";
    }

    @RequestMapping(
            value = "/testPut",
            method = RequestMethod.PUT
    )
    public String testPut() {
        return "success";
    }
      /*
    3.RequestMapping注解的params属性:
    3.1.@RequestMapping注解的params属性通过请求的请求参数匹配请求映射
    3.2.@RequestMapping注解的params属性是一个字符串类型的数组，可以通过四种表达式设置请求参数和请求映射的匹配关系
    3.3.取值的几种情况:
    3.3.1."param":要求请求映射所匹配的请求必须携带param请求参数
    3.3.2."!param":要求请求映射所匹配的请求必须不能携带param请求参数
    3.3.3."param=value":要求请求映射所匹配的请求必须携带param请求参数且param=value
    3.3.4."param!=value":要求请求映射所匹配的请求必须携带param请求参数但是param!=value
    注意:
    若当前请求满足@RequestMapping注解的value和method属性，但是不满足params属性，此时页面回报错400:
    Parameter conditions "username, password!=123456" not met for actual request parameters: username={admin}, password={123456}
     */
    /*
    4.@RequestMapping注解的headers属性:
    4.1.@RequestMapping注解的headers属性通过请求的请求头信息匹配请求映射
    4.2.@RequestMapping注解的headers属性是一个字符串类型的数组，可以通过四种表达式设置请求头信息和请求映射的匹配关系
    4.3.取值的几种情况:
    4.3.1."header":要求请求映射所匹配的请求必须携带header请求头信息
    4.3.2."!header":要求请求映射所匹配的请求必须不能携带header请求头信息
    4.3.3."header=value":要求请求映射所匹配的请求必须携带header请求头信息且header=value
    4.3.4."header!=value":要求请求映射所匹配的请求必须携带header请求头信息且header!=value
    注意:
    若当前请求满足@RequestMapping注解的value和method属性，但是不满足headers属性，此时页面显示404错误，即资源未找到
     */

    @RequestMapping(
            params = {"username", "password!=123456"},
            headers = {"Host=localhost:8080"}
    )
    public String testParamsAndHeaders() {
        return "success";
    }


    //5.SpringMVC支持ant风格的路径:
    //5.1.?:表示任意的单个字符
    //5.2.*:表示任意的0个或多个字符
    //5.3.**:表示任意的一层或多层目录(也可以是0层)
    //5.4.注意:在使用**时，只能使用/**/xxx的方式，不能是/x**x/xxx的方式

    //@RequestMapping("/a?a/testAnt")
    //@RequestMapping("/a*a/testAnt")
    @RequestMapping("/**/testAnt")
    public String testAnt() {
        return "success";
    }

    /*
    6.SpringMVC支持路径中的占位符:
    原始方式:/deleteUser?id=1
    rest方式:/deleteUser/1
    SpringMVC路径中的占位符常用于RESTful风格中，当请求路径中将某些数据通过路径的方式传输到服务器中，就可以在相应的
    @RequestMapping注解的value属性中通过占位符{xxx}表示传输的数据，在通过@PathVariable注解，将占位符所表示的数据
    赋值给控制器方法的形参
     */
    @RequestMapping("testPath/{id}/{username}")
    public String testPath(@PathVariable("id") Integer id, @PathVariable("username") String username) {
        System.out.println("id:" + id + ",username:" + username);
        return "success";
    }

}
