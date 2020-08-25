package com.udacity.jdnd.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.data.entity.Plant;
import com.udacity.jdnd.service.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    public PlantDTO getPlantDTO(String name){
        PlantDTO plantDTO = convertPlantEntityToDTO(plantService.getPlantByName(name));
        return plantDTO;
    }

    private PlantDTO convertPlantEntityToDTO(Plant plantByName) {
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plantByName,plantDTO);
        return plantDTO;
    }

    @JsonView(NameAndPrice.class)
    public Plant getFilteredPlant(String name){
        return plantService.getPlantByName(name);
    }
}
