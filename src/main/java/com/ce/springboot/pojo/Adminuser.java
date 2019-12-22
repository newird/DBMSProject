package com.ce.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * adminuser
 * @author 
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Adminuser {
    private Integer id;

    private String adminuser;

    private String password;

    private String perm;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public String getAdminuser() {
        return adminuser;
    }

    public String getPassword() {
        return password;
    }

    public String getPerm() {
        return perm;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAdminuser(String adminuser) {
        this.adminuser = adminuser;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }
}