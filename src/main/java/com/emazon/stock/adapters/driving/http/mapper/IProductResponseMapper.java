package com.emazon.stock.adapters.driving.http.mapper;

import com.emazon.stock.adapters.driving.http.dto.response.ProductResponse;
import com.emazon.stock.domain.model.Product;

import java.util.List;

public interface IProductResponseMapper {
    ProductResponse toProductResponse(Product product);
    List<ProductResponse> toProductResponsesList(List<Product> products);
}
