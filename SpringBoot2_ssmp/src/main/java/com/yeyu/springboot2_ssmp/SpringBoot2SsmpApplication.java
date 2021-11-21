package com.yeyu.springboot2_ssmp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringBoot2SsmpApplication {
    public static void main(String[] args) {
        System.out.println(Arrays.asList(args));
        SpringApplication.run(SpringBoot2SsmpApplication.class, args);
    }
}
