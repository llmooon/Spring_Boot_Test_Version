package com.soma.tripper.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestApi {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
