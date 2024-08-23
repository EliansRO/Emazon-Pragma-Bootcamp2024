package com.emazon.stock.adapters.driven.jpa.mysql.adapter;

import com.emazon.stock.adapters.driven.jpa.mysql.entity.BrandEntity;
import com.emazon.stock.adapters.driven.jpa.mysql.exception.BrandAlreadyExistsException;
import com.emazon.stock.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.emazon.stock.adapters.driven.jpa.mysql.mapper.IBrandEntityMapper;
import com.emazon.stock.adapters.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.emazon.stock.adapters.driven.jpa.mysql.repository.IBrandRepository;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.spi.IBrandPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class BrandAdapter implements IBrandPersistencePort {
    private final IBrandRepository brandRepository;
    private final IBrandEntityMapper brandEntityMapper;

    @Override
    public void saveBrand(Brand brand) {
        if (brandRepository.findByName(brand.getName()).isPresent()) {
            throw new BrandAlreadyExistsException();
        }
        brandRepository.save(brandEntityMapper.toEntity(brand));
    }

    @Override
    public List<Brand> getAllBrands(Integer page, Integer size, String sortOrder) {
        Pageable pagination = PageRequest.of(page, size);
        List<BrandEntity> brands = brandRepository.findAll(pagination).getContent();
        if (brands.isEmpty()) {
            throw new NoDataFoundException();
        }
        return brandEntityMapper.toModelList(brands);
    }
}
