package com.ce.springboot.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * order_good
 * @author 
 */
@Data
@NoArgsConstructor

public class OrderGood implements Serializable {
    private String orderid;

    private Integer goodid;

    private Integer num;

    public OrderGood(String orderid, Integer goodid, Integer num) {
        this.orderid = orderid;
        this.goodid = goodid;
        this.num = num;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    private static final long serialVersionUID = 1L;
}