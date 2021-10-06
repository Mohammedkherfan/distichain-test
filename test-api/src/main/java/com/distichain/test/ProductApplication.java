package com.distichain.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ProductApplication {

    public static void main(String str[]) {
        SpringApplication.run(ProductApplication.class, str);
    }
}
