package com.udacity.jdnd.service;

import com.udacity.jdnd.data.entity.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantService {
    public Plant getPlantByName(String name){
        return new Plant();
    }
}
