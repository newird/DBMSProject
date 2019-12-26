package com.ce.springboot.pojo;

import lombok.Data;

@Data
public class goodnum {
    private Integer goodid;

    private String name;

    private Integer expiry;

    private Integer temperature;

    private String type;

    private Integer mass;

    private String packages;

    private Integer length;

    private Integer width;

    private Integer height;

    private String unit;

    private Integer num;

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getExpiry() {
        return expiry;
    }

    public void setExpiry(Integer expiry) {
        this.expiry = expiry;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMass() {
        return mass;
    }

    public void setMass(Integer mass) {
        this.mass = mass;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public goodnum() {
    }

    public goodnum(Integer goodid, String name, Integer expiry, Integer temperature, String type, Integer mass, String packages, Integer length, Integer width, Integer height, String unit, Integer num) {
        this.goodid = goodid;
        this.name = name;
        this.expiry = expiry;
        this.temperature = temperature;
        this.type = type;
        this.mass = mass;
        this.packages = packages;
        this.length = length;
        this.width = width;
        this.height = height;
        this.unit = unit;
        this.num = num;
    }
}
