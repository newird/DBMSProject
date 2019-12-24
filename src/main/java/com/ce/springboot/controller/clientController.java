package com.ce.springboot.controller;

import com.ce.springboot.dao.ClientDao;
import com.ce.springboot.dao.ContactmanDao;
import com.ce.springboot.pojo.Client;
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
        clientDao.deleteClientById(id);
        contactmanDao.deleteByCompany(id);
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
        if (id == client.getCompanycode()){
            clientDao.updateById(client);
        }else{
            clientDao.insertClient(client);
            clientDao.deleteClientById(id);
        }

        return "redirect:/clients";
    }
    @GetMapping("/addClient")
    public String addClient(Model model){
        return "client/add";
    }
    @PostMapping("/addClient")
    public String clientadd(Client client ,Model model){
        int i = clientDao.insertClient(client);
        if(i == 1){
            return "redirect:clients";
        }else{
            return "client/add";
        }
    }

    @PostMapping("/searchClient?search={search}")
    public String searchClient(Model model, String search){
        List<Client> client = clientDao.searchClient(search);
        model.addAttribute("client",client);
        return "redirect:/clients";
    }
}
