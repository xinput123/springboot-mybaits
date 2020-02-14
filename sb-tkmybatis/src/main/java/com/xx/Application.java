package com.xx;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.xx.mapper") // 注意，要换成 tk 提供的 @MapperScan 注解
public class Application {
}
