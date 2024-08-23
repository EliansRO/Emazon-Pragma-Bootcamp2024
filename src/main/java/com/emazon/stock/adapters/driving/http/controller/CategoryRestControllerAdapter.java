package com.emazon.stock.adapters.driving.http.controller;

import com.emazon.stock.adapters.driving.http.dto.request.AddCategoryRequest;
import com.emazon.stock.adapters.driving.http.dto.response.CategoryResponse;
import com.emazon.stock.adapters.driving.http.mapper.ICategoryRequestMapper;
import com.emazon.stock.adapters.driving.http.mapper.ICategoryResponseMapper;
import com.emazon.stock.domain.api.ICategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryRestControllerAdapter {
    private final ICategoryServicePort categoryServicePort;
    private final ICategoryRequestMapper categoryRequestMapper;
    private final ICategoryResponseMapper categoryResponseMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addCategory(@RequestBody AddCategoryRequest request) {
        categoryServicePort.saveCategory(categoryRequestMapper.addRequestToCategory(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryResponse>> getAllCategories(@RequestParam Integer page, @RequestParam Integer size, @RequestParam String sortOrder) {
        return ResponseEntity.ok(categoryResponseMapper.
                toCategoryResponsesList(categoryServicePort.getAllCategories(page, size, sortOrder)));
    }
}
