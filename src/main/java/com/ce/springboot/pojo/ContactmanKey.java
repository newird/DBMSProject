package com.ce.springboot.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * contactman
 * @author 
 */
@Data
public class ContactmanKey implements Serializable {
    private Integer company;

    private Integer employeeid;

    private static final long serialVersionUID = 1L;
}