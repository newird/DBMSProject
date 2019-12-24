package com.ce.springboot.controller;/*
 *用户: 张策
 *邮箱: newird@protonmail.com
 *编码时间: 2019/12/11 0011
 */

import com.ce.springboot.pojo.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public String hello(Client client,Model model){
        model.addAttribute("client",client);
        return "test";
    }
//   @PostMapping("/test1")
//    public String test(@RequestParam(value="province") String province, Model model){
//        model.addAttribute("p",province);
//        model.addAttribute("msg","hello");
//        return "test";
//   }
    @PostMapping("/test")
    public String post(Client client, Model model){
//        order.setOrderid(UUID.randomUUID().toString().replaceAll("-","").substring(2, 10));
////        order.setTime(new Date());
////        model.addAttribute("o",order);
        model.addAttribute("client",client);
        return "test";
    }
    @RequestMapping("/order/add")

    public String adfhn(){
        return "order/add";
    }
    @RequestMapping("/good/add")

    public String adfhnaa(){
        return "good/add";
    }
    @RequestMapping("/client/add")

    public String adfhnww(){
        return "client/add";
    }

    @RequestMapping("/address")
    public String address(){
        return "address";
    }
}
