package com.emazon.stock.domain.api;

import com.emazon.stock.domain.model.Category;

import java.util.List;

public interface ICategoryServicePort {
    void saveCategory(Category category);
    List<Category> getAllCategories(Integer page, Integer size, String sortOrder);
}
