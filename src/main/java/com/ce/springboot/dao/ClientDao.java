package com.ce.springboot.dao;

import com.ce.springboot.pojo.Client;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClientDao {
    int insert(Client record);

    int insertSelective(Client record);

    List<Client> select ();

    boolean delete(int companycode);

    Client selectById(int companycode);

    int updateById(Client record);


}