package com.ce.springboot.controller;

import com.ce.springboot.dao.*;
import com.ce.springboot.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
