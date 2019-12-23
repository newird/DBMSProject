package com.ce.springboot.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class adminLogin {
    @RequestMapping("/backboard")
    public String loginSuccess(){
        return "backboard";
    }


}
//    @Autowired
//    private AdminuserDao adminuserDao;
//    @RequestMapping("/userLogin")
//    public String login(Model model, @RequestParam("username") String useradmin,@RequestParam("password") String password){
//        Adminuser adminuser = adminuserDao.selectByUsername(useradmin);
//        String pwd = new MyPasswordEncoder().encode(password);
////        System.out.println(pwd);
//        if (pwd.equals(adminuser.getPassword())) {
////        if(adminuser != null){
//            return "backboard";
//        }else{
//            model.addAttribute("msg","登陆失败");
//            return "login";
//        }
//    }
//}
