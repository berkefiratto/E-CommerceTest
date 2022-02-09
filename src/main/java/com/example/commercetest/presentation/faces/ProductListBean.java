package com.example.commercetest.presentation.faces;

import com.example.commercetest.data.entity.Product;
import com.example.commercetest.data.repository.ProductRepository;
import com.example.commercetest.data.repository.impl.ProductRepositoryImpl;

import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;

@ManagedBean
@RequestScoped
public class ProductListBean {

    private List<Product> productList;

    public ProductListBean() throws Exception {
        ProductRepository productRepository = new ProductRepositoryImpl();
        productList = productRepository.findAllProducts();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}