package com.emazon.stock.adapters.driving.http.dto.request;

import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.model.Category;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
public class AddProductRequest {
    private final String name;
    private final String description;
    private final Integer quantity;
    private final BigDecimal price;
    private final Long brandId;
    private List<Long> categoryIds;
}
