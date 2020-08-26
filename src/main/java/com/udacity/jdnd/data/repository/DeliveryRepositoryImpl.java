package com.udacity.jdnd.data.repository;

import com.udacity.jdnd.data.entity.Delivery;
import com.udacity.jdnd.data.entity.Delivery_;
import com.udacity.jdnd.data.entity.Plant;
import com.udacity.jdnd.data.entity.Plant_;
import com.udacity.jdnd.data.entity.projection.RecipientAndPrice;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class DeliveryRepositoryImpl implements DeliveryRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void persist(Delivery delivery) {
        entityManager.persist(delivery); //write delivery to the database
    }

    @Override
    public Delivery find(Long id) {
        Delivery d = entityManager.find(Delivery.class,id);
        return d;
    }

    @Override
    public Delivery merge(Delivery delivery) {
        Delivery d = entityManager.merge(delivery);
        return d;
    }

    @Override
    public void delete(Long id) {
        Delivery d = entityManager.find(Delivery.class,id);
        entityManager.remove(d);
    }

    @Override
    public List<Delivery> findDeliveryByName(String recipientName){
        List<Delivery>  deliveries = entityManager.createNamedQuery( "Delivery.findDeliveriesByName").
                setParameter("recipientName",recipientName).getResultList();
        return deliveries;
    }

    @Override
    // One possible way to solve this - query a list of Plants with deliveryId matching
    // the one provided and sum their prices.
    public RecipientAndPrice getBill(Long deliveryId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPrice> query = cb.createQuery(RecipientAndPrice.class);
        Root<Plant> root = query.from(Plant.class);
        query.select(
                cb.construct(
                        RecipientAndPrice.class,
                        root.get("delivery").get("name"),
                        cb.sum(root.get("price"))))
                .where(cb.equal(root.get("delivery").get("id"), deliveryId));
        return entityManager.createQuery(query).getSingleResult();
    }
}
