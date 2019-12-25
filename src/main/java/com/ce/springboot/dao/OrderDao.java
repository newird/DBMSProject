package com.ce.springboot.dao;

import com.ce.springboot.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderDao {

        List<Order> selectOrder();

        List<Order> getSubmit();

        List<Order> getPass();

        List<Order> getUnpass();
}