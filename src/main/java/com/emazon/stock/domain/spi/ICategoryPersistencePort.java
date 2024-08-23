package com.emazon.stock.domain.spi;

import com.emazon.stock.domain.model.Category;

import java.util.List;

public interface ICategoryPersistencePort {
    void saveCategory(Category category);
    List<Category> getAllCategories(Integer page, Integer size, String sortOrder);
}
