package com.udacity.jdnd.data.repository;

import com.udacity.jdnd.data.entity.Delivery;
import com.udacity.jdnd.data.entity.Plant;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PlantRepositoryTest {
 @Autowired
private TestEntityManager entityManager;
@Autowired
private PlantRepository plantRepository;

    @Test
    void testPriceLessThan() {
        Delivery d1 = new Delivery();
        d1.setAddress("ilexweg 1,22111");
        entityManager.persist(d1);
        Plant p1 = new Plant();
        p1.setName("plantA");
        p1.setPrice(new BigDecimal(10));
        p1.setDelivery(d1);
        entityManager.persist(p1);
        Plant p2 = new Plant();
        p2.setName("plantB");
        p2.setPrice(new BigDecimal(49));
        p2.setDelivery(d1);
        entityManager.persist(p2);
        List<Plant> plantsList1 = plantRepository.findPlantByPriceLessThan(new BigDecimal(30));
        assertEquals(1,plantsList1.size());

        List<Plant> plantsList2 = plantRepository.findPlantByPriceLessThan(new BigDecimal(100));
        assertEquals(2,plantsList2.size());
    }

    @Test
    void testDeliveryCompleted() {
        Delivery d1 = new Delivery();
        d1.setAddress("ilexweg 1,22111");
        d1.setCompleted(true);
        entityManager.persist(d1);
        Plant p1 = new Plant();
        p1.setName("plantA");
        p1.setPrice(new BigDecimal(10));
        p1.setDelivery(d1);
        entityManager.persist(p1);
        assertTrue(plantRepository.isPlantDeliveryComplete(p1.getId()));
    }

    @Test
    public void testIsDeliveryCompleted() {
        Plant p = entityManager.persist(new Plant("Baz Root", new BigDecimal(9.99)));
        Delivery d = entityManager.persist(new Delivery("Leonard Bernstein", "234 West Side", LocalDateTime.now()));
        d.setCompleted(false);
        d.setPlants(Lists.newArrayList(p));
        p.setDelivery(d);

        //test both before and after
       assertFalse(plantRepository.isPlantDelivered(p.getId()));
        d.setCompleted(true);
        assertTrue(plantRepository.isPlantDelivered(p.getId()));
    }

}