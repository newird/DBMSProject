package com.ce.springboot.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * contactman
 * @author 
 */
@Data
@NoArgsConstructor
public class Contactman {
    private String name;

    private String title;

    private String phone;

    private Integer tax;

    private String email;

    private int company;

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

    public Contactman(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }
}