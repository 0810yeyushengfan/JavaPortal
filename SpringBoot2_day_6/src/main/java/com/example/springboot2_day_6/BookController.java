package com.example.springboot2_day_6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping
    public void getAll() {
        System.out.println("SpringBoot2 is running!");
    }

}
