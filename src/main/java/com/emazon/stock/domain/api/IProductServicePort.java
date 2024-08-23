package com.emazon.stock.domain.api;

import com.emazon.stock.domain.model.Product;

import java.util.List;

public interface IProductServicePort {
    void saveProduct(Product product);
    List<Product> getAllProducts();
}
