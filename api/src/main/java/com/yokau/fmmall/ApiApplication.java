package com.yokau.fmmall;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan("com.yokau.fmmall.dao")
@EnableScheduling
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
