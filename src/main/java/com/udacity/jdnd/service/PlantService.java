package com.udacity.jdnd.service;

import com.udacity.jdnd.data.entity.Plant;
import com.udacity.jdnd.data.repository.PlantRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public  class PlantService {
    private PlantRepository repository;

    public PlantService(PlantRepository repository) {
        this.repository = repository;
    }

    public Long orderPlant(Plant plant) {
        Plant plant1 = repository.save(plant);
        return plant1.getId();
    }

    public boolean checkDeliveryStatus(Long plantId) {
        return repository.isPlantDeliveryComplete(plantId);
    }

    public List<Plant> listPlantsCheaperThanGivenPrice(BigDecimal price) {
        return repository.findPlantByPriceLessThan(price);
    }
    public Plant getPlantByName(String name){
        return repository.findPlantByName(name);
    }

}
