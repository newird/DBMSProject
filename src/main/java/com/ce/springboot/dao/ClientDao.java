package com.ce.springboot.dao;

import com.ce.springboot.pojo.Client;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClientDao {

    List<Client> selectClient();

}