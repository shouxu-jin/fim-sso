package com.yytxdy.fim.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.yytxdy.fim.sso.mapper")
public class FimSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FimSsoApplication.class, args);
    }

}
