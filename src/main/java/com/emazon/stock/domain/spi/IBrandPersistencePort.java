package com.emazon.stock.domain.spi;

import com.emazon.stock.domain.model.Brand;

import java.util.List;

public interface IBrandPersistencePort {
    void saveBrand(Brand brand);
    List<Brand> getAllBrands(Integer page, Integer size, String sortOrder);
}
