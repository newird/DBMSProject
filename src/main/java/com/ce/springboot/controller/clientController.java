package com.ce.springboot.controller;

import com.ce.springboot.dao.ClientDao;
import com.ce.springboot.dao.ContactmanDao;
import com.ce.springboot.pojo.Client;
import com.ce.springboot.pojo.Contactman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
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
    public String deleteContactman(@PathVariable("id") int id,Model model){
        Contactman contactman = contactmanDao.selectById(id);
        int company = contactman.getCompany();
        int i = contactmanDao.numOfContactman(company);
        if( i> 1){
            contactmanDao.deleteById(id);

        }else{
            model.addAttribute("msg","不能删除");
        }
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
    @PostMapping("/clientsearch")
    public  String search(String namezh,String nameen,String namesp,
            String province,String city,Model model){
        HashMap<Object, Object> map = new HashMap<>();
        if (!namezh.equals("")) {
            map.put("namezh",namezh);
        }
        if (!nameen.equals("")) {
            map.put("nameen",nameen);
        }
        if (!namesp.equals("")) {
            map.put("namesp",namesp);
        }
        if (!province.equals("")) {
            map.put("province",province);
        }
        if (!city.equals("")) {
            map.put("city",city);
        }

        List<Client> clients = clientDao.searchClient(map);
        model.addAttribute("clients",clients);
        return "client/clientList";

    }
}
