package com.ce.springboot.controller;/*
 *用户: 张策
 *邮箱: newird@protonmail.com
 *编码时间: 2019/12/13 0013
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/userList")
    //查询数据库的所有信息
    public List<Map<String,Object>> userList(){
        String sql = "select * from test";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
}
