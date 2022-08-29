package com.curiousbinary.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${ui.msg1}")
    private String msg1;
    @Value("${ui.msg2}")
    private String msg2;

    @Value("${ui.msg3}")
    private String msg3;

    @GetMapping("/")
    public String helloWorld() {
        return msg1 + " " + msg2 + " " + msg3;
    }

}
