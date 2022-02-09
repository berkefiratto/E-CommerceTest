package com.example.commercetest.data.repository;

import com.example.commercetest.data.entity.Cart;

public interface CartRepository {

    void persist(Cart cart);
}
