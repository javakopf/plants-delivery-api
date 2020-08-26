package com.udacity.jdnd.data.entity;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NamedQueries(
        @NamedQuery(
                name = "Delivery.findDeliveriesByName",
                query = "select d from Delivery d where d.recipientName = :recipientName")
)
@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 500,name = "address_full")
    private String address;
    @Nationalized
    private String recipientName;
    private LocalDateTime deliveryTime;
    @Type(type = "yes_no")
    private Boolean completed;

    @OneToMany(mappedBy = "delivery",cascade = CascadeType.ALL)
    @OnDelete( action = OnDeleteAction.CASCADE )
    private List<Plant> plants;

    public Delivery() {
    }


    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Boolean isCompleted() {
        return completed;
    }
    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

}
