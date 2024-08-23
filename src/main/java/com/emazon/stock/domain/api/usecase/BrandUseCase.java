package com.emazon.stock.domain.api.usecase;

import com.emazon.stock.domain.api.IBrandServicePort;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.spi.IBrandPersistencePort;

import java.util.List;

public class BrandUseCase implements IBrandServicePort {
    private IBrandPersistencePort brandPersistencePort;

    public BrandUseCase(IBrandPersistencePort brandPersistencePort) {
        this.brandPersistencePort = brandPersistencePort;
    }

    @Override
    public void saveBrand(Brand brand) {
        brandPersistencePort.saveBrand(brand);
    }

    @Override
    public List<Brand> getAllBrands(Integer page, Integer size, String sortOrder) {
        return brandPersistencePort.getAllBrands(page, size, sortOrder);
    }
}
