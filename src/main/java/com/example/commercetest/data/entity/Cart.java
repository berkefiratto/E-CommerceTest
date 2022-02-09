package com.example.commercetest.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Cart implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    private String customerName;

    @OneToMany(mappedBy = "Cart", cascade = CascadeType.ALL)
    private List<CartProduct> cartProductList;

    public Cart() {
    }

    public Cart(long cartId, String customerName, List<CartProduct> cartProductList) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.cartProductList = cartProductList;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<CartProduct> getCartProductList() {
        return cartProductList;
    }

    public void setCartProductList(List<CartProduct> cartProductList) {
        this.cartProductList = cartProductList;
    }
}
