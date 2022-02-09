package com.example.commercetest.data.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CartProduct implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartProductId;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private double salesQuantity;

    public CartProduct() {
    }

    public CartProduct(long cartProductId, Cart cart, Product product, double salesQuantity) {
        this.cartProductId = cartProductId;
        this.cart = cart;
        this.product = product;
        this.salesQuantity = salesQuantity;
    }

    public long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(long cartProductId) {
        this.cartProductId = cartProductId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(double salesQuantity) {
        this.salesQuantity = salesQuantity;
    }
}
