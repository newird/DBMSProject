package com.ce.springboot.service;

import com.ce.springboot.dao.ClientDao;
import com.ce.springboot.dao.GoodDao;
import com.ce.springboot.dao.OrderDao;
import com.ce.springboot.dao.OrderGoodDao;
import com.ce.springboot.pojo.OrderResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class getOrderResult {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderGoodDao orderGoodDao;
    @Autowired
    private GoodDao goodDao;
    @Autowired
    private ClientDao clientDao;
    private List<OrderResult> orderres;


//    public List<Order> getOrderResult() {
//        List<Order> orders = orderDao.selectAll();
//        for (Order order : orders) {
//            OrderResult orderResult = new OrderResult();
//            orderResult.setOrder(order);
//            int clientId = order.getClient();
//            Client client = clientDao.selectById(clientId);
//            orderResult.setClient(client);
//            List<Integer> goodsId = orderGoodDao.order2good(order.getOrderid());
//            List<Good> goods = new ArrayList<>();
//            for (Integer goodId : goodsId) {
//                goods.add(goodDao.selectByPrimaryKey(goodId));
//            }
//            orderResult.setGood(goods);
//            orderres.add(orderResult);
//        }
//        return orderres;
//        return orders;
//    }
}
