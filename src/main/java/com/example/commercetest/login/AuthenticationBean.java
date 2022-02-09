package com.example.commercetest.login;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

@ManagedBean
@SessionScoped
public class AuthenticationBean {

    private String username;

    private String password;

    private boolean signIn;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSignIn() {
        return signIn;
    }

    public void setSignIn(boolean signIn) {
        this.signIn = signIn;
    }

    public String login() {
        if (username.equals("Berke") && password.equals("12345")) {
            signIn = true;
            return "Home";
        } else {
            signIn = false;
            return "Login";
        }
    }
}
