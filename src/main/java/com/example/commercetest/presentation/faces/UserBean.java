package com.example.commercetest.presentation.faces;

import com.example.commercetest.data.entity.User;
import com.example.commercetest.data.repository.UserRepository;
import com.example.commercetest.data.repository.impl.UserRepositoryImpl;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    private User user;

    public UserBean() {
        user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String save() {
        System.out.println("Saklanıyor : " + user.getEmail());
        UserRepository userRepository = new UserRepositoryImpl();
        userRepository.registerUser(user);
        return "Home";
    }
}
