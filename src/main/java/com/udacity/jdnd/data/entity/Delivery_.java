package com.udacity.jdnd.data.entity;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import java.util.List;

@StaticMetamodel(Delivery.class)
public class Delivery_ {
    public static volatile SingularAttribute<Delivery, Long> id;
    public static volatile SingularAttribute<Delivery, String> address;
    public static volatile SingularAttribute<Delivery, String> recipientName;
    public static volatile SingularAttribute<Delivery, LocalDateTime> deliveryTime;
    public static volatile SingularAttribute<Delivery, Boolean> completed;
    public static volatile SetAttribute<Delivery,Plant> plants;

}

