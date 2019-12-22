package com.ce.springboot.service;

import com.ce.springboot.dao.AdminuserDao;
import com.ce.springboot.pojo.Adminuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class adminLogin {
    @Autowired
    private AdminuserDao adminuserDao;
    @RequestMapping("/userLogin")
    public String login(Model model, @RequestParam("username") String useradmin,@RequestParam("password") String password){
        Adminuser adminuser = adminuserDao.selectByUsername(useradmin);
        String pwd = new MyPasswordEncoder().encode(password);
//        System.out.println(pwd);
        if (pwd.equals(adminuser.getPassword())) {
//        if(adminuser != null){
            return "backboard";
        }else{
            model.addAttribute("msg","登陆失败");
            return "login";
        }
    }
}
