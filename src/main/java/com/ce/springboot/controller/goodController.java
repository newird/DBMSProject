package com.ce.springboot.controller;

import com.ce.springboot.dao.GoodDao;
import com.ce.springboot.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class goodController {

    @Autowired
    private GoodDao goodDao;

    @GetMapping("/goods")
    public String list(Model model){

        List<Good> goods =  goodDao.selectAllGood();
//        //将结果放在请求中

        model.addAttribute("goods",goods);

        return "good/goodList";
    }
    @GetMapping("/delGood/{id}")
    public String delGood(@PathVariable("id") Integer id){
        goodDao.deleteGood(id);
        return "redirect:/goods";
    }
    @GetMapping("/goodupdate/{id}")
    public String goodupdate(@PathVariable("id") Integer id ,Model model){
        Good good = goodDao.selectByPrimaryKey(id);
        model.addAttribute("good",good);
        return "good/update";
    }
    @PostMapping("/goodupdate")
    public String updategood(Good good){
        goodDao.updateByPrimaryKeySelective(good);
        return "redirect:/goods";
    }
    @PostMapping("/goodadd")
    public String goodadd(Good good){
        goodDao.insert(good);
        return "redirect:/goods";
    }
    @GetMapping("/addGood")
    public String addGoodd(){

        return "good/add";
    }
    @PostMapping("/goodsearch")
    public String searchgood(String  id,String name,Model model){
        HashMap<Object, Object> map = new HashMap<>();
        if(!id.equals("")){
            int goodid= Integer.parseInt(id);
            map.put("goodid",goodid);
//            model.addAttribute("goodid",goodid);
        }
        if(!name.equals("")){
            map.put("goodname",name);
//            model.addAttribute("name",name);
        }
        List<Good> goods = goodDao.fuzzsearch(map);
        model.addAttribute("goods",goods);
        return "good/goodList";
//        model.addAttribute("name",name);
//        return "test";
    }

}
