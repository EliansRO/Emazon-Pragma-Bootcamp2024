package com.emazon.stock.adapters.driven.jpa.mysql.mapper;

import com.emazon.stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.emazon.stock.domain.model.Category;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class ICategoryEntityMapperTest {

    private final ICategoryEntityMapper mapper = Mappers.getMapper(ICategoryEntityMapper.class);

    @Test
    void testToEntity() {
        Category category = new Category(1L, "Electronics");
        CategoryEntity categoryEntity = mapper.toEntity(category);

        assertEquals(category.getId(), categoryEntity.getId());
        assertEquals(category.getName(), categoryEntity.getName());
    }

    @Test
    void testToModel() {
        CategoryEntity categoryEntity = new CategoryEntity(1L, "Electronics");
        Category category = mapper.toModel(categoryEntity);

        assertEquals(categoryEntity.getId(), category.getId());
        assertEquals(categoryEntity.getName(), category.getName());
    }
}