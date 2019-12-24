package com.ce.springboot.dao;

import com.ce.springboot.pojo.OrderGood;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderGoodDao {
    int insert(OrderGood record);

    int insertSelective(OrderGood record);

    List<Integer> order2good(String  orderId);

    List<Integer> order2num(String orderId);

    int deleteOrderById(String id);
}