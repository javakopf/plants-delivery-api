package com.udacity.jdnd.service;

import com.udacity.jdnd.data.entity.Delivery;
import com.udacity.jdnd.data.entity.Plant;
import com.udacity.jdnd.data.entity.projection.RecipientAndPrice;
import com.udacity.jdnd.data.repository.DeliveryRepository;
import com.udacity.jdnd.data.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }

    public RecipientAndPrice getBill(Long deliveryId) {
        return deliveryRepository.getBill(deliveryId);

    }
}
