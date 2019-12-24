package com.ce.springboot.controller;

import com.ce.springboot.dao.*;
import com.ce.springboot.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class orderController {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderGoodDao orderGoodDao;
    @Autowired
    private GoodDao goodDao;
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private OrderDao2 orderDao2;
    private String id;

    @GetMapping("/orders")
    public String order(Model model){
        List<Order> orders = orderDao.selectOrder();
        List<Order> check = new ArrayList<>();
        List<Order> uncheck = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCheck() != null) {
                check.add(order);
            }else{
                uncheck.add(order);
            }
        }
        model.addAttribute("orders",check);
        model.addAttribute("uncheck",uncheck);
        return "order/orderList";
    }

    @GetMapping("/addOrder")
    public String addOrder(Model model){
        List<Client> clients = clientDao.selectClient();
        List<Good> goods = goodDao.selectAllGood();
        model.addAttribute("clients",clients);
        model.addAttribute("goods",goods);
        return "order/add";
    }
    @PostMapping("/addOrder")
    public String orderadd(Order2 order, OrderGood orderGood){
        String OrderId = UUID.randomUUID().toString().replaceAll("-","").substring(2, 10);
        order.setOrderid(OrderId);
        order.setTime(new Date());
        orderDao2.insert(order);
//        for (OrderGood orderGood : orderGoods) {
            orderGood.setOrderid(OrderId);
            orderGoodDao.insert(orderGood);
//        }

        return "redirect:/orders";
    }
    @GetMapping("/orderCheck/{id}")
    public String check(@PathVariable("id") String id){
        orderDao2.check(id);
        return "redirect:/orders";
    }
    @GetMapping("/orderCheckF/{id}")
    public String unpass(@PathVariable("id") String id){
        orderDao2.upass(id);
        return "redirect:/orders";
    }
    @GetMapping("/delOrder/{id}")

    public String deleteOrder(@PathVariable("id") String id){
        orderGoodDao.deleteOrderById(id);
        orderDao2.deleteByPrimaryKey(id);
        return "redirect:/orders";
    }

    @GetMapping("/delog/{id}")

    public String deleteog(@PathVariable("id")String id){
        String orderId = id.substring(0,8);
        String goodId = id.substring(8);

        orderGoodDao.deleteByKey(orderId,Integer.parseInt(goodId));

        return "redirect:/orders";
    }
    @GetMapping("/Orderupdate/{id}")
    public String updateOrder(Model model,@PathVariable("id") String id){
        Order2 order = orderDao2.selectByPrimaryKey(id);
        model.addAttribute("order",order);
        List<Client> clients = clientDao.selectClient();
        model.addAttribute("clients",clients);
//        List<Good> good = goodDao.selectAllGood();
//        model.addAttribute("good",good);
        return "order/update";
    }

    @PostMapping("/updateOrder")
    public String uuupdateOrder(Order2 order){
        orderDao2.updateByPrimaryKey(order);
        return "redirect:/orders";
    }

    @PostMapping("/addoGood")
    public String ooggadd(OrderGood orderGood){
        orderGood.setOrderid(id);
        orderGoodDao.insert(orderGood);
        return "redirect:/orders";
    }
    @GetMapping("/addoGood/{id}")
    public String ooggsssadd(Model model,@PathVariable("id")String id){
        this.id = id;
        List<Good> goods = goodDao.selectAllGood();
        model.addAttribute("good",goods);
        return "order/addGood";

    }
}
