package com.udacity.jdnd.data.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
public class Flower extends Plant{
    private String color;


    public Flower() {
    }


}
