package com.ce.springboot.dao;

import com.ce.springboot.pojo.Adminuser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminuserDao {
    Adminuser selectLogin(String adminuser,String password);

    List<Adminuser> selectAllUser();

    int deleteByPrimaryKeyUser(Integer id);

    int insertUser(Adminuser record);

    int insertSelectiveUser(Adminuser record);

    Adminuser selectByPrimaryKeyUser(Integer id);

    int updateByPrimaryKeySelectiveUser(Adminuser record);

    int updateByPrimaryKeyUser(Adminuser record);

    Adminuser selectByUsername(String username);

    int userexist(String name);
}