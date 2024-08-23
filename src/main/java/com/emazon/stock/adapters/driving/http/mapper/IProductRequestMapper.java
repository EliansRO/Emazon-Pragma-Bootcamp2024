package com.emazon.stock.adapters.driving.http.mapper;

import com.emazon.stock.adapters.driving.http.dto.request.AddProductRequest;
import com.emazon.stock.domain.model.Product;

public interface IProductRequestMapper {
    Product addRequestToProduct(AddProductRequest addProductRequest);
}
