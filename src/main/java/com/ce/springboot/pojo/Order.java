package com.ce.springboot.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * order
 * @author 
 */
@Data
public class Order implements Serializable {
    private String orderid;

    private Integer client;

    private String send;

    private String sphone;

    private String semail;

    private String sprovince;

    private String scity;

    private String receive;

    private String rphone;

    private String remail;

    private String rprovince;

    private String rcity;

    private Date time;

    private String check;

    private static final long serialVersionUID = 1L;
}