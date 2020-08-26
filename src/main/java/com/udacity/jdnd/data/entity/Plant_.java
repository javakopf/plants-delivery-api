package com.udacity.jdnd.data.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.controller.NameAndPrice;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@StaticMetamodel(Plant.class)
public class Plant_ {
    public static volatile SingularAttribute<Plant, Long> id;
    public static volatile SingularAttribute<Plant, BigDecimal> name;
    public static volatile SingularAttribute<Plant, BigDecimal> price;
    public static volatile SingularAttribute<Plant,Delivery> delivery;

}
