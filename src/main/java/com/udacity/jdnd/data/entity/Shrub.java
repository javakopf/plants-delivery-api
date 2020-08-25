package com.udacity.jdnd.data.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Shrub extends Plant{

    private Integer  height;
    private Integer  width;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}
