package com.mbti.jhta_3team_finalproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.mbti.jhta_3team_finalproject.mybatis.mapper")
@SpringBootApplication
public class Jhta3TeamFinalProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(Jhta3TeamFinalProjectApplication.class, args);
    }

}
