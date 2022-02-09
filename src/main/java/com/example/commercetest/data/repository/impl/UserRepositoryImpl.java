package com.example.commercetest.data.repository.impl;

import com.example.commercetest.data.entity.User;
import com.example.commercetest.data.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final EntityManager entityManager;

    public UserRepositoryImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProjectTestPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public User registerUser(User user) {
        System.out.println("Ekleniyor : " + user.getEmail());

        entityManager.getTransaction().begin();
        entityManager.persist(user);

        entityManager.close();
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public User findUser(long userId) {
        return entityManager.find(User.class, userId);
    }

    @Override
    public void removeUser(long userId) {
        User user = findUser(userId);
        if (user != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public List<User> findAllUsers() {
        TypedQuery<User> typedQuery = entityManager.createNamedQuery("User.findAll", User.class);
        return typedQuery.getResultList();
    }

    @Override
    public User loginControl(String username, String email) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
