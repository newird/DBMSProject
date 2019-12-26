package com.ce.springboot.controller;

import com.ce.springboot.dao.*;
import com.ce.springboot.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

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
    public String order(Model model) {
        List<Order> orders = orderDao.selectOrder();
        List<Order> submit = new ArrayList<>();
        List<Order> unsubmit = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCheck() != null) {
                submit.add(order);
            } else {
                unsubmit.add(order);
            }
        }
        model.addAttribute("submit", submit);
        model.addAttribute("unsubmit", unsubmit);
        return "order/orderList";
    }

    @GetMapping("/addOrder")
    public String addOrder(Model model) {
        List<Client> clients = clientDao.selectClient();
        List<Good> goods = goodDao.selectAllGood();
        model.addAttribute("clients", clients);
        model.addAttribute("goods", goods);
        return "order/add";
    }

    @PostMapping("/addOrder")
    public String orderadd(Order2 order, OrderGood orderGood) {
        String OrderId = UUID.randomUUID().toString().replaceAll("-", "").substring(2, 10);
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
    public String check(@PathVariable("id") String id) {
        orderDao2.check(id);
        return "redirect:/orderscheck";
    }

    @GetMapping("/orderCheckF/{id}")
    public String unpass(@PathVariable("id") String id) {
        orderDao2.upass(id);
        return "redirect:/orderscheck";
    }

    @GetMapping("/delOrder/{id}")

    public String deleteOrder(@PathVariable("id") String id) {
        orderGoodDao.deleteOrderById(id);
        orderDao2.deleteByPrimaryKey(id);
        return "redirect:/orders";
    }

    @GetMapping("/delog/{id}")

    public String deleteog(@PathVariable("id") String id, Model model) {
        String orderId = id.substring(0, 8);
        String goodId = id.substring(8);

        orderGoodDao.deleteByKey(orderId, Integer.parseInt(goodId));
//        model.addAttribute("o",orderId);
//        model.addAttribute("g",goodId);
        return "redirect:/orders";
    }

    @GetMapping("/Orderupdate/{id}")
    public String updateOrder(Model model, @PathVariable("id") String id) {
        Order2 order = orderDao2.selectByPrimaryKey(id);
        model.addAttribute("order", order);
        List<Client> clients = clientDao.selectClient();
        model.addAttribute("clients", clients);
//        List<Good> good = goodDao.selectAllGood();
//        model.addAttribute("good",good);
        return "order/update";
    }

    @PostMapping("/updateOrder")
    public String uuupdateOrder(Order2 order,Model model) {
        orderDao2.updateByPrimaryKey(order);
        return "redirect:/orders";
//        model.addAttribute("order",order);
//        return "test";
    }


    @PostMapping("/addoGood")
    public String ooggadd(OrderGood orderGood,Model model) {
        orderGood.setOrderid(id);
        if(orderGoodDao.ordergoodexist(id,orderGood.getGoodid()) == 1){
            int num = orderGoodDao.selectnum(id, orderGood.getGoodid());
            orderGood.setNum(orderGood.getNum() + num);
            orderGoodDao.updateNum(orderGood);
        }else{
            orderGoodDao.insert(orderGood);
        }
        return "redirect:/orders";
    }

    @GetMapping("/addoGood/{id}")
    public String ooggsssadd(Model model, @PathVariable("id") String id) {
        this.id = id;
        List<Good> goods = goodDao.selectAllGood();
        model.addAttribute("good", goods);
        return "order/addGood";

    }



    @GetMapping("/orderSubmit/{id}")
    public String submit(@PathVariable("id") String id) {
        orderDao2.submit(id);
        return "redirect:/orders";
    }

    @PostMapping("/OrderForm")
    public String sdofno(String orderid, String company
            , String send, String sphone,
                         String receive, String rphone
            , Model model) {
//        try {
        HashMap<Object, Object> map = new HashMap<>();
        if (!orderid.equals("")) {
            map.put("orderid", orderid);
        }
        if (!company.equals("")) {
            map.put("company", company);
        }
        if (!send.equals("")) {
            map.put("send", send);
        }
        if (!sphone.equals("")) {
            map.put("sphone", sphone);
        }
        if (!receive.equals("")) {
            map.put("receive", receive);
        }
        if (!rphone.equals("")) {
            map.put("rphone", rphone);
        }
//            map.put("orderid",orderid);
        List<Order> orders = orderDao.fuzzselect(map);
        model.addAttribute("orders", orders);
        List<Order> submit = new ArrayList<>();
        List<Order> unsubmit = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCheck() != null) {
                submit.add(order);
            } else {
                unsubmit.add(order);
            }
        }
        model.addAttribute("submit", submit);
        model.addAttribute("unsubmit", unsubmit);

        return "order/orderList";
//        return "test";
    }


    @GetMapping("/orderscheck")
    public String oc(Model model) {
        List<Order> submit = orderDao.getSubmit();
        List<Order> pass = orderDao.getPass();
        List<Order> unpass = orderDao.getUnpass();
        model.addAttribute("submit", submit);
        model.addAttribute("pass", pass);
        model.addAttribute("unpass", unpass);
        return "order/CheckOrder";
    }
    @PostMapping("/ordercheckForm")
    public String sdofcckkoo(String orderid, String company
            , String send, String sphone,
                             String receive, String rphone
            , Model model) {
//        try {
        HashMap<Object, Object> map = new HashMap<>();
        if (!orderid.equals("")) {
            map.put("orderid", orderid);
        }
        if (!company.equals("")) {
            map.put("company", company);
//            model.addAttribute("pass",company);
        }
        if (!send.equals("")) {
            map.put("send", send);
        }
        if (!sphone.equals("")) {
            map.put("sphone", sphone);
        }
        if (!receive.equals("")) {
            map.put("receive", receive);
        }
        if (!rphone.equals("")) {
            map.put("rphone", rphone);
        }
        List<Order> submit = orderDao.getSubmitfuzz(map);
        model.addAttribute("submit", submit);
        List<Order> pass = orderDao.getPassfuzz(map);
        model.addAttribute("pass", pass);
        List<Order> unpass = orderDao.getUnpassfuzz(map);
        model.addAttribute("unpass", unpass);
        return "order/CheckOrder";
//        return "test";
    }
    @GetMapping("/cdelOrder/{id}")

    public String afeleteOrder(@PathVariable("id") String id) {
        orderGoodDao.deleteOrderById(id);
        orderDao2.deleteByPrimaryKey(id);
        return "redirect:/orderscheck";
    }
    @GetMapping("/cdelog/{id}")

    public String asdeleteog(@PathVariable("id") String id, Model model) {
        String orderId = id.substring(0, 8);
        String goodId = id.substring(8);
        orderGoodDao.deleteByKey(orderId, Integer.parseInt(goodId));
        return "redirect:/orderscheck";
    }
    @GetMapping("/cOrderupdate/{id}")
    public String asupdateOrder(Model model, @PathVariable("id") String id) {
        Order2 order = orderDao2.selectByPrimaryKey(id);
        model.addAttribute("order", order);
        List<Client> clients = clientDao.selectClient();
        model.addAttribute("clients", clients);
//        List<Good> good = goodDao.selectAllGood();
//        model.addAttribute("good",good);
        return "order/cupdate";
    }

    @PostMapping("/cupdateOrder")
    public String uuuaspdateOrder(Order2 order) {
        orderDao2.updateByPrimaryKey(order);
        return "redirect:/orderscheck";
    }
    @GetMapping("/caddoGood/{id}")
    public String ooggsasssadd(Model model, @PathVariable("id") String id) {
        this.id = id;
        List<Good> goods = goodDao.selectAllGood();
        model.addAttribute("good", goods);
        return "order/caddGood";

    }
    @PostMapping("/caddoGood")
    public String ooggadasd(OrderGood orderGood, Model model) {
        orderGood.setOrderid(id);
        if(orderGoodDao.ordergoodexist(id,orderGood.getGoodid()) == 1){
            int num = orderGoodDao.selectnum(id, orderGood.getGoodid());
            orderGood.setNum(orderGood.getNum() + num);
            orderGoodDao.updateNum(orderGood);
        }else{
            orderGoodDao.insert(orderGood);
        }
        return "redirect:/orderscheck";
    }


}
