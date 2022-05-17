package com.alex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "Buna seara!";
    }

    @GetMapping("hello")
    public String hello() {
        return "Hellooo!!!!";
    }

}
