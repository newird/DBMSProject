package com.ce.springboot.dao;

import com.ce.springboot.pojo.Order2;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderDao2 {
    int deleteByPrimaryKey(String orderid);

    int insert(Order2 record);

    int insertSelective(Order2 record);

    Order2 selectByPrimaryKey(String orderid);

    int updateByPrimaryKeySelective(Order2 record);

    int updateByPrimaryKeyWithBLOBs(Order2 record);

    int updateByPrimaryKey(Order2 record);

    int check(String id);

    int upass(String id);
}