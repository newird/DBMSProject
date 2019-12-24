package com.ce.springboot.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderGoodKey {

    private String orderId;
    private int goodId;

    public OrderGoodKey(String orderId, int goodId) {
        this.orderId = orderId;
        this.goodId = goodId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }
}
