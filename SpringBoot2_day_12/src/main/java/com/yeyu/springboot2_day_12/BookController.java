package com.yeyu.springboot2_day_12;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {
    //需要引入org.slf4j.Logger而不是java.util.logging.Logger
    //private static final Logger log = LoggerFactory.getLogger(BookController.class);
    @GetMapping
    public void getAll() {
        log.debug("debug ...");
        log.info("info ...");
        log.warn("warn ...");
        log.error("error ...");
        System.out.println("SpringBoot2 is running!");
    }
}
