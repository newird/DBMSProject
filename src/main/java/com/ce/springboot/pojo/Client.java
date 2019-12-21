package com.ce.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * client
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public String getNamezh() {
        return namezh;
    }

    public String getNameen() {
        return nameen;
    }

    public String getNamesp() {
        return namesp;
    }

    public String getEmail() {
        return email;
    }

    public String getBlankid() {
        return blankid;
    }

    public String getBlank() {
        return blank;
    }

    public Integer getCompanycode() {
        return companycode;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public List<Contactman> getContactman() {
        return contactman;
    }

    public void setContactman(List<Contactman> contactman) {
        this.contactman = contactman;
    }

    public Client(String namezh, String nameen, String namesp, String email, String blankid, String blank, Integer companycode, String province, String city) {
        this.namezh = namezh;
        this.nameen = nameen;
        this.namesp = namesp;
        this.email = email;
        this.blankid = blankid;
        this.blank = blank;
        this.companycode = companycode;
        this.province = province;
        this.city = city;
    }


}