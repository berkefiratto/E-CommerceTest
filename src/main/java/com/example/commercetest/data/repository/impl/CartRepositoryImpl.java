package com.example.commercetest.data.repository.impl;

import com.example.commercetest.data.entity.Cart;
import com.example.commercetest.data.repository.CartRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CartRepositoryImpl implements CartRepository {

    public EntityManager entityManager;

    public CartRepositoryImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjectTestPU");
        entityManager = entityManagerFactory.createEntityManager();
    }


    @Override
    public void persist(Cart cart) {
        entityManager.getTransaction().begin();
        entityManager.persist(cart);
        entityManager.getTransaction().commit();
    }
}
