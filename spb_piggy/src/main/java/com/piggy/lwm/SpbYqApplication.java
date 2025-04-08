package com.piggy.lwm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.piggy.lwm.mapper")
public class SpbYqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbYqApplication.class, args);
    }

}
