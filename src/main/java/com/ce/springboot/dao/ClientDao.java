package com.ce.springboot.dao;

import com.ce.springboot.pojo.Client;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ClientDao {

    List<Client> selectClient();

    int deleteClientById(int id);

    int insertClient(Client client);

    Client selectById(int id);

    int updateById(Client client);

    List<Client> searchClient(Map map);




}