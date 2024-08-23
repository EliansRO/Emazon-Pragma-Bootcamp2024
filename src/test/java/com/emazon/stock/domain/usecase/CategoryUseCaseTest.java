package com.emazon.stock.domain.usecase;

import com.emazon.stock.domain.api.usecase.CategoryUseCase;
import com.emazon.stock.domain.spi.ICategoryPersistencePort;
import com.emazon.stock.domain.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryUseCaseTest {

    @Mock
    private ICategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveCategoryTest() {
        Category category = new Category(1L, "Electronics");

        doNothing().when(categoryPersistencePort).saveCategory(category);

        categoryUseCase.saveCategory(category);

        verify(categoryPersistencePort, times(1)).saveCategory(category);
    }

    // Otros tests...
}