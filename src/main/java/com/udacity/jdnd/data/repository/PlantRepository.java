package com.udacity.jdnd.data.repository;

import com.udacity.jdnd.data.entity.Plant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlantRepository extends CrudRepository<Plant,Long> {
    @Query("select p.delivery.completed from Plant p where :plantId = p.id ")
    boolean isPlantDelivered(Long plantId);

    @Query("select p.delivery.completed from Plant p where :plantId = p.id ")
    boolean isPlantDeliveryComplete(Long plantId);

    @Query("select p from Plant p where :price > p.price ")
    List<Plant> findPlantByPriceLessThan(BigDecimal price);

    @Query("select p from Plant p where :name = p.name")
    Plant findPlantByName(String name);
}
