package com.udacity.jdnd.data.repository;

import com.udacity.jdnd.data.entity.Delivery;
import com.udacity.jdnd.data.entity.projection.RecipientAndPrice;

import java.util.List;

public interface DeliveryRepository {
    void persist(Delivery delivery);
    Delivery find(Long id);
    Delivery merge(Delivery delivery);
    void delete(Long id);
    List<Delivery> findDeliveryByName(String recipientName);
    RecipientAndPrice getBill(Long deliveryId);
}
