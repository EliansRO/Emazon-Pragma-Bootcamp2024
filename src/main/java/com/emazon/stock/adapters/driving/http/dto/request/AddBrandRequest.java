package com.emazon.stock.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddBrandRequest {
    private final Long id;
    private final String name;
    private final String description;
}
