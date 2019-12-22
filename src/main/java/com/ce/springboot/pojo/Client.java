package com.ce.springboot.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * client
 * @author 
 */
@Data
@NoArgsConstructor
public class Client  {
    private String namezh;

    private String nameen;

    private String namesp;

    private String email;

    private String blankid;

    private String blank;

    private Integer companycode;

    private String province;

    private String city;

    private List<Contactman> contactman;


    public Client(String namezh, List<Contactman> contactman) {
        this.namezh = namezh;
        this.contactman = contactman;
    }

    @Override
    public String toString() {
        return "Client{" +
                "namezh='" + namezh + '\'' +
                ", nameen='" + nameen + '\'' +
                ", namesp='" + namesp + '\'' +
                ", email='" + email + '\'' +
                ", blankid='" + blankid + '\'' +
                ", blank='" + blank + '\'' +
                ", companycode=" + companycode +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", contactman=" + contactman +
                '}';
    }

    private static final long serialVersionUID = 1L;

    public Client(String namezh, String nameen, String namesp,
                  String email, String blankid, String blank,
                  Integer companycode, String province, String city,
                  List<Contactman> contactman) {
        this.namezh = namezh;
        this.nameen = nameen;
        this.namesp = namesp;
        this.email = email;
        this.blankid = blankid;
        this.blank = blank;
        this.companycode = companycode;
        this.province = province;
        this.city = city;
        this.contactman = contactman;
    }

    public String getNamezh() {
        return namezh;
    }

    public void setNamezh(String namezh) {
        this.namezh = namezh;
    }

    public String getNameen() {
        return nameen;
    }

    public void setNameen(String nameen) {
        this.nameen = nameen;
    }

    public String getNamesp() {
        return namesp;
    }

    public void setNamesp(String namesp) {
        this.namesp = namesp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBlankid() {
        return blankid;
    }

    public void setBlankid(String blankid) {
        this.blankid = blankid;
    }

    public String getBlank() {
        return blank;
    }

    public void setBlank(String blank) {
        this.blank = blank;
    }

    public Integer getCompanycode() {
        return companycode;
    }

    public void setCompanycode(Integer companycode) {
        this.companycode = companycode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Contactman> getContactman() {
        return contactman;
    }

    public void setContactman(List<Contactman> contactman) {
        this.contactman = contactman;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}