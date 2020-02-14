package com.xx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.xx.mapper")
public class Application {
    public static void main(String[] args) {

    }
}
