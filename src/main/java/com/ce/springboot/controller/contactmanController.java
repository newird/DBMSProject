package com.ce.springboot.controller;

import com.ce.springboot.dao.ContactmanDao;
import com.ce.springboot.pojo.Contactman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class contactmanController {

    @Autowired
    private ContactmanDao contactmanDao;

    @GetMapping("delCon/{id}")
    public String toDel(@PathVariable("id") Integer id){
        contactmanDao.deleteById(id);
        return "redirect:/clients";
    }
    @GetMapping("/updateCon/{id}")
    public String clientupdate(@PathVariable("id") Integer id , Model model){
        Contactman contactman = contactmanDao.selectById(id);
        model.addAttribute("c",contactman);
        return "client/update";
    }
    @PostMapping("/updateCon")
    public String updateclient(Contactman contactman){
        contactmanDao.updateById(contactman);
        return "redirect:/clients";
    }
    @GetMapping("/addCon")
    public String addClient(Model model){
        return "contactman/add";
    }
    @PostMapping("/addCon")
    public String clientadd(Contactman contactman ,Model model){
        int i = contactmanDao.insert(contactman);
        if(i == 1){
            return "redirect:clients";
        }else{
            return "contactman/add";
        }
    }
}
