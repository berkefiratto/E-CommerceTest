package com.example.commercetest.data.repository;

import com.example.commercetest.data.entity.User;

import java.util.List;

public interface UserRepository {

    User registerUser(User user);

    User findUser(long userId);

    User loginControl(String username, String email);

    void removeUser(long userId);

    List<User> findAllUsers();
}
