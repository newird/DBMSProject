package com.ce.springboot.dao;

import com.ce.springboot.pojo.Good;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface GoodDao {
    List<Good> selectAllGood();

    int deleteGood(int id);

    boolean insert(Good good);

    Good selectByPrimaryKey(int id);

    void updateByPrimaryKeySelective(Good good);

    List<Good> fuzzsearch(Map map);
}