package com.ce.springboot.controller;/*
 *用户: 张策
 *邮箱: newird@protonmail.com
 *编码时间: 2019/12/11 0011
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello cece";
    }
}
