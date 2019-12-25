package com.ce.springboot.dao;

import com.ce.springboot.pojo.Client;
import com.ce.springboot.pojo.Contactman;
import com.ce.springboot.pojo.ContactmanKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ContactmanDao {
    int deleteByPrimaryKey(ContactmanKey key);

    int insert(Contactman record);

    int insertSelective(Contactman record);

    Contactman selectByPrimaryKey(ContactmanKey key);

    int updateByPrimaryKeySelective(Contactman record);

    int updateByPrimaryKey(Contactman record);

    List<Client> getCompany();

    List<Contactman> getContactman();

    int deleteByCompany(int  id);

    int deleteById(int  id);

    Contactman selectById(int id);

    int updateById(Contactman contactman);

    int numOfContactman(int id);
}