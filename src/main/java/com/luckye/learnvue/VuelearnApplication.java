package com.luckye.learnvue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.luckye.learnvue.dao")
public class VuelearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(VuelearnApplication.class, args);
    }

}
