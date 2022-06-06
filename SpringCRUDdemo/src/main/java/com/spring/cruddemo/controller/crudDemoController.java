package com.spring.cruddemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class crudDemoController {

    @Value("${welcome.message}")
    private String msg;

    @GetMapping("/")
    public String sayHello(){
        return msg;
    }
}
