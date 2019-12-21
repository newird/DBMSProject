package com.ce.springboot.controller;

import com.ce.springboot.dao.ClientDao;
import com.ce.springboot.dao.GoodDao;
import com.ce.springboot.dao.OrderDao;
import com.ce.springboot.dao.OrderGoodDao;
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


    @GetMapping("/orders")
    public String order(Model model){
//        List<OrderResult> orderres = new ArrayList<>();
//        List<Order> orders = orderDao.selectAll();
//        OrderResult orderResult = null;
//        for (Order order : orders) {
//            orderResult = new OrderResult();
//            orderResult.setOrder(order);
//            int clientId = order.getClient();
//            Client client = clientDao.selectById(clientId);
//            orderResult.setClient(client);
//            List<Integer> num = orderGoodDao.order2num(order.getOrderid());
//            orderResult.setNum(num);
//            List<Integer> goodsId = orderGoodDao.order2good(order.getOrderid());
//            List<Good> goods = new ArrayList<>();
//            for (Integer goodId : goodsId) {
//                goods.add(goodDao.selectByPrimaryKey(goodId));
//            }
//            orderResult.setGood(goods);
//            orderres.add(orderResult);

        }
        model.addAttribute("orders",orderres);
        return "order/orderList";
    }

    @GetMapping("/addOrder")
    public String addOrder(Model model){
        List<Client> clients = clientDao.select();
        List<Good> goods = goodDao.selectAllGood();
        model.addAttribute("clients",clients);
        model.addAttribute("goods",goods);
        return "order/add";
    }
    @PostMapping("/addOrder")
    public String orderadd(Order order, OrderGood orderGood){
        String OrderId = UUID.randomUUID().toString().replaceAll("-","").substring(2, 10);
        order.setOrderid(OrderId);
        order.setTime(new Date());
//        orderDao.insert(order);
            orderGood.setOrderid(OrderId);
//        model.addAttribute("o",order);
//        model.addAttribute("g",orderGood);
        orderDao.insert(order);
//        orderGoodDao.insert(orderGood);
        return "redirect:/orders";
    }
}
