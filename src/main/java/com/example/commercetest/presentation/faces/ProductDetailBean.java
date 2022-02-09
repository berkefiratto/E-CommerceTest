package com.example.commercetest.presentation.faces;

import com.example.commercetest.data.entity.Product;
import com.example.commercetest.data.repository.impl.ProductRepositoryImpl;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class ProductDetailBean implements Serializable {

    private Product product;

    public ProductDetailBean() {

        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequest();

        if (request.getParameter("productId") != null) {
            long productId = Long.parseLong(request.getParameter("productId"));

            product = new ProductRepositoryImpl().findProductsById(productId);
        }
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}