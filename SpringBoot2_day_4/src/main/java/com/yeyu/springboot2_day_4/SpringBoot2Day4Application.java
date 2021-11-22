package com.yeyu.springboot2_day_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot2Day4Application {

    public static void main(String[] args) {
        //通过编程形式带参数启动SpringBoot程序，为程序添加运行参数
        //String[] arg = new String[1];
        //arg[0] = "--server.port=8081";
        //SpringApplication.run(SpringBoot2Day4Application.class, arg);

        //不携带参数启动SpringBoot程序
        SpringApplication.run(SpringBoot2Day4Application.class);
    }

}
