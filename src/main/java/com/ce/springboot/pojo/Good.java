package com.ce.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * good
 * @author 
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Good implements Serializable {
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
    public int getGoodId(){
        return goodid;
    }


    public String getName() {
        return name;
    }

    public Integer getExpiry() {
        return expiry;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public String getType() {
        return type;
    }

    public Integer getMass() {
        return mass;
    }

    public String getPackages() {
        return packages;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public String getUnit() {
        return unit;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return Objects.equals(goodid, good.goodid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodid);
    }
}