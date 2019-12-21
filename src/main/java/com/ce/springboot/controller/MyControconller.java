package com.ce.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyControconller {

    @RequestMapping({"/","/login"})
    public String hello(){
        return "login";
    }


}
