package com.study.user;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.study.user.mapper.**.*")
public class UserServiceApplication {


    public static void main(String args[]) {
        SpringApplication.run(UserServiceApplication.class, args);
    }


}
