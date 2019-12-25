package com.ce.springboot.controller;

import com.ce.springboot.dao.ClientDao;
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
    @Autowired
    private ClientDao clientDao;

    @GetMapping("/delContactman{id}")
    public String toDel(Model model,@PathVariable("id") Integer id){
        Contactman contactman = contactmanDao.selectById(id);
        int cid = contactman.getCompany();
        int i = contactmanDao.numOfContactman(cid);
        if(i ==1){
            model.addAttribute("msg","剩一个吧");
        }else{
            contactmanDao.deleteById(id);
        }
        return "redirect:/clients";
    }
    @GetMapping("/updateContactman/{id}")
    public String clientupdate(@PathVariable("id") Integer id , Model model){
        Contactman contactman = contactmanDao.selectById(id);
        model.addAttribute("c",contactman);
        return "contactman/update";
    }
    @PostMapping("/updateContactman")
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
