package com.ce.springboot.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * order
 * @author 
 */
@Data
@NoArgsConstructor
public class Order2 implements Serializable {
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

    public Order2(String orderid, Integer client, String send, String sphone, String semail, String sprovince, String scity, String receive, String rphone, String remail, String rprovince, String rcity, Date time, String check) {
        this.orderid = orderid;
        this.client = client;
        this.send = send;
        this.sphone = sphone;
        this.semail = semail;
        this.sprovince = sprovince;
        this.scity = scity;
        this.receive = receive;
        this.rphone = rphone;
        this.remail = remail;
        this.rprovince = rprovince;
        this.rcity = rcity;
        this.time = time;
        this.check = check;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getSprovince() {
        return sprovince;
    }

    public void setSprovince(String sprovince) {
        this.sprovince = sprovince;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public String getRphone() {
        return rphone;
    }

    public void setRphone(String rphone) {
        this.rphone = rphone;
    }

    public String getRemail() {
        return remail;
    }

    public void setRemail(String remail) {
        this.remail = remail;
    }

    public String getRprovince() {
        return rprovince;
    }

    public void setRprovince(String rprovince) {
        this.rprovince = rprovince;
    }

    public String getRcity() {
        return rcity;
    }

    public void setRcity(String rcity) {
        this.rcity = rcity;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    private static final long serialVersionUID = 1L;
}