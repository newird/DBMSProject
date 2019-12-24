package com.ce.springboot.controller;

import com.ce.springboot.dao.ClientDao;
import com.ce.springboot.dao.ContactmanDao;
import com.ce.springboot.pojo.Client;
import com.ce.springboot.pojo.Contactman;
import com.ce.springboot.pojo.search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class clientController {
    private int id;
    @Autowired
    private ContactmanDao contactmanDao;
    @Autowired
    private ClientDao clientDao;

    @GetMapping("/clients")
    public String clientList(Model model){
        List<Client> clients = clientDao.selectClient();
        model.addAttribute("clients",clients);
        return "client/clientList";
    }
    @GetMapping("delClient/{id}")
    public String toDel(@PathVariable("id") Integer id){
        contactmanDao.deleteByCompany(id);
        clientDao.deleteClientById(id);
        return "redirect:/clients";
    }
    @GetMapping("/updateClient/{id}")
    public String clientupdate(@PathVariable("id") Integer id ,Model model){
        this.id = id;
        Client client = clientDao.selectById(id);
        model.addAttribute("client",client);
        return "client/update";
    }
    @PostMapping("/updateClient")
    public String updateclient(Client client){
        clientDao.updateById(client);
        return "redirect:/clients";
    }
    @GetMapping("/addClient")
    public String addClient(Model model){
        return "client/add";
    }
    @PostMapping("/addClient")
    public String clientadd(Client client , Contactman contactman,Model model){
        clientDao.insertClient(client);
        contactman.setCompany(client.getCompanycode());
        contactmanDao.insert(contactman);
        return "redirect:clients";
    }

    @PostMapping("/searchClient")
    public String searchClient(Model model, search search){
        List<Client> client = clientDao.searchClient(search);
        model.addAttribute("client",client);
        return "redirect:clients";

    }
    @GetMapping("/addCon/{id}")

    public String addComman(@PathVariable("id") int id){
        this.id = id;
        return "contactman/add";
    }
    @PostMapping("/addCom")

    public String addCommanmmnn(Contactman contactman){
        contactman.setCompany(id);
        contactmanDao.insert(contactman);
        return "redirect:/clients";
    }
    @GetMapping("/delContactman/{id}")
    public String deleteContactman(@PathVariable("id") int id){
        contactmanDao.deleteById(id);
        return "redirect:/clients";
    }
    @GetMapping("/updateContactman/{id}")
    public String update(Model model,@PathVariable("id") int id){
        Contactman contactman = contactmanDao.selectById(id);
        model.addAttribute("contactman",contactman);
        return "contactman/update";
//        return "test";
    }
    @PostMapping("/updateContactman")
    public String update(Contactman contactman){
        contactmanDao.updateByPrimaryKey(contactman);
        return "redirect:clients";
//        return "test";
    }
}
