package com.emazon.stock.adapters.driven.jpa.mysql.mapper;

import com.emazon.stock.adapters.driven.jpa.mysql.entity.ProductEntity;
import com.emazon.stock.domain.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductEntityMapper {
    Product toModel(ProductEntity productEntity);

    ProductEntity toEntity(Product product);

    List<Product> toModelList(List<ProductEntity> productEntities);
}
