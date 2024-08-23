package com.emazon.stock.adapters.driven.jpa.mysql.mapper;

import com.emazon.stock.adapters.driven.jpa.mysql.entity.BrandEntity;
import com.emazon.stock.domain.model.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBrandEntityMapper {

    Brand toModel (BrandEntity brandEntity);

    BrandEntity toEntity (Brand brand);

    List<Brand> toModelList (List<BrandEntity> brandEntities);
}
