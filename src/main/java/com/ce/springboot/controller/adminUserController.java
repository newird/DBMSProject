package com.ce.springboot.controller;

import com.ce.springboot.dao.AdminuserDao;
import com.ce.springboot.pojo.Adminuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class adminUserController {
    @Autowired
    private AdminuserDao adminuserDao;

    @GetMapping("/users")
    public String list(Model model){

        List<Adminuser> users =  adminuserDao.selectAllUser();
//        //将结果放在请求中

        model.addAttribute("users",users);

        return "user/userList";
    }
    @GetMapping("/delUser/{id}")
    public String delUser(@PathVariable("id") Integer id){
        adminuserDao.deleteByPrimaryKeyUser(id);
        return "redirect:/users";
    }

    @GetMapping("/updateUser/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        Adminuser adminuser = adminuserDao.selectByPrimaryKeyUser(id);
        model.addAttribute("user",adminuser);
        return "user/update";
    }
    @PostMapping("/userUpdate")
    public String Updateuser(Adminuser user){
        String password = user.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        password = "{bcrypt}"+password;
        user.setPassword(password);
       adminuserDao.updateByPrimaryKeySelectiveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/addUser")
    public String adduser(){
        return "user/add";
    }
    @PostMapping("/addUser")
    public String addUser(Adminuser user){
        String password = user.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        password = "{bcrypt}"+password;
        user.setPassword(password);
        adminuserDao.insertSelectiveUser(user);
        return "redirect:/users";
    }

}
