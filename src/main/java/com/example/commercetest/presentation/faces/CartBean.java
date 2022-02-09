package com.example.commercetest.presentation.faces;

import com.example.commercetest.data.entity.Cart;
import com.example.commercetest.data.entity.CartProduct;
import com.example.commercetest.data.entity.Product;
import com.example.commercetest.data.repository.CartRepository;
import com.example.commercetest.data.repository.impl.CartRepositoryImpl;
import com.example.commercetest.data.repository.impl.ProductRepositoryImpl;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class CartBean implements Serializable {

    private Cart cart;

    public CartBean() {
        cart = new Cart();
        cart.setCartProductList(new ArrayList<>());
    }

    public void add() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequest();

        long productId = Long.parseLong(request.getParameter("productId"));
        Product product = new ProductRepositoryImpl().findProductsById(productId);
        CartProduct cartProduct = new CartProduct();
        cartProduct.setProduct(product);
        cartProduct.setCart(cart);
        cart.getCartProductList().add(cartProduct);

    }

    public void checkOut() {
        CartRepository cartRepository = new CartRepositoryImpl();
        cartRepository.persist(cart);

    }

    public Cart getCart() {
        return cart;
    }

}