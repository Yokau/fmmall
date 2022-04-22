package com.yokau.tkmapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.yokau.tkmapper.dao")
public class TkmapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(TkmapperApplication.class, args);
    }

}
