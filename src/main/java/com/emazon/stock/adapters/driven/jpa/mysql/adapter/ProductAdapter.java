package com.emazon.stock.adapters.driven.jpa.mysql.adapter;

import com.emazon.stock.adapters.driven.jpa.mysql.entity.ProductEntity;
import com.emazon.stock.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.emazon.stock.adapters.driven.jpa.mysql.exception.ProductAlreadyExistsException;
import com.emazon.stock.adapters.driven.jpa.mysql.mapper.IProductEntityMapper;
import com.emazon.stock.adapters.driven.jpa.mysql.repository.IProductRepository;
import com.emazon.stock.domain.model.Product;
import com.emazon.stock.domain.spi.IProductPersistencePort;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
public class ProductAdapter implements IProductPersistencePort {
    private final IProductRepository productRepository;
    private final IProductEntityMapper productEntityMapper;

    @Override
    public void saveProduct(Product product) {
        if (productRepository.findByName(product.getName()).isPresent(){
            throw new ProductAlreadyExistsException();
        }
        productRepository.save(productEntityMapper.toEntity(product));
    }

    @Override
    public List<Product> getProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        if (productEntities.isEmpty()){
            throw new NoDataFoundException();
        }
        return productEntityMapper.toModelList(productEntities);
    }
}
