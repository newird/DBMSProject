package com.ce.springboot.pojo;

import lombok.Data;

/**
 * contactman
 * @author 
 */
@Data
public class Contactman {
    private String name;

    private String title;

    private String phone;

    private Integer tax;

    private String email;

//    private int company;

    private Integer employeeid;
    private static final long serialVersionUID = 1L;

    public Contactman(String name, String title, String phone, Integer tax, String email, Integer employeeid) {
        this.name = name;
        this.title = title;
        this.phone = phone;
        this.tax = tax;
        this.email = email;
        this.employeeid = employeeid;
    }

    @Override
    public String toString() {
        return "Contactman{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", phone=" + phone +
                ", tax=" + tax +
                ", email='" + email + '\'' +
                ", employeeid=" + employeeid +
                '}';
    }
//
//    public int getCompany() {
//        return company;
//    }
//
//    public void setCompany(int company) {
//        this.company = company;
//    }
}