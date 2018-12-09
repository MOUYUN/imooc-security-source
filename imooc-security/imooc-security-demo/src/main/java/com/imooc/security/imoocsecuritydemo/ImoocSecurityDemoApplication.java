package com.imooc.security.imoocsecuritydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ImoocSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImoocSecurityDemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring Security";
    }
}
