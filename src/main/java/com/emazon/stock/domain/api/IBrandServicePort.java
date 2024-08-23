package com.emazon.stock.domain.api;

import com.emazon.stock.domain.model.Brand;

import java.util.List;

public interface IBrandServicePort {
    void saveBrand(Brand brand);
    List<Brand> getAllBrands(Integer page, Integer size, String sortOrder);
}
