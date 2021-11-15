package com.yeyu.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/*
7.ResponseEntity:
ResponseEntity用于控制器方法的返回值类型，该控制器方法的返回值就是响应到浏览器的响应报文
 */
@Controller
public class FileUpAndDownController {
    //文件下载
    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //1.获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //2.获取服务器中文件的真实路径(是在target目录下的SpringMVC_day_5-1.0-SNAPSHOT中)
        String realPath = servletContext.getRealPath("/static/img/1.jpg");
        //3.创建输入流
        InputStream is = new FileInputStream(realPath);
        //4.创建字节数组
        byte[] bytes = new byte[is.available()];
        //5.将流读到字节数组中
        is.read(bytes);
        //6.创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //7.设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //8.设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //9.创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //10.关闭输入流
        is.close();
        //11.返回ResponseEntity对象
        return responseEntity;
    }

    //文件上传
    //SpringMVC中将上传的文件封装到MultipartFile对象中，通过此对象可以获取文件相关信息
    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo, HttpSession session) throws IOException {
        //1.获取上传的文件的文件名
        String fileName = photo.getOriginalFilename();
        //2.处理文件重名问题
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + hzName;
        //3.获取服务器中photo目录的路径，如果没有photo目录创建一个
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        File file = new File(photoPath);
        if (!file.exists()) {
            file.mkdir();
        }
        //File.separator得到的是File的分隔符
        String finalPath = photoPath + File.separator + fileName;
        //4.实现上传功能
        photo.transferTo(new File(finalPath));
        return "success";
    }

}
