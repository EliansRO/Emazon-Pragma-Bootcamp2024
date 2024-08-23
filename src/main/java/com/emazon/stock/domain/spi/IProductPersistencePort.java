package com.emazon.stock.domain.spi;

import com.emazon.stock.domain.model.Product;

import java.util.List;

public interface IProductPersistencePort {
    void saveProduct(Product product);
    List<Product> getProducts();
}
