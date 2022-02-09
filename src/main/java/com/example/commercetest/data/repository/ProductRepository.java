package com.example.commercetest.data.repository;

import com.example.commercetest.data.entity.Product;

import java.util.List;

public interface ProductRepository {

    void saveProduct(Product product);

    void deleteProduct(Product product);

    Product updateProduct(Product product);

    Product findProductsById(long productId);

    List<Product> findAllProducts() throws Exception;
}
