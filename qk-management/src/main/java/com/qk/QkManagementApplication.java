package com.qk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan   //开启对servlet组件的扫描
@SpringBootApplication
public class QkManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(QkManagementApplication.class, args);
    }

}
