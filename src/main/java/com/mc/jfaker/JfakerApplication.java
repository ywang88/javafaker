package com.mc.jfaker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.mc.jfaker.mapper")
@SpringBootApplication
public class JfakerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JfakerApplication.class, args);
    }

}
