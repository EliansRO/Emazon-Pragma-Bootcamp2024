package com.emazon.stock.adapters.driving.http.controller;

import com.emazon.stock.adapters.driving.http.dto.request.AddProductRequest;
import com.emazon.stock.adapters.driving.http.dto.response.ProductResponse;
import com.emazon.stock.adapters.driving.http.mapper.IProductRequestMapper;
import com.emazon.stock.adapters.driving.http.mapper.IProductResponseMapper;
import com.emazon.stock.domain.api.IProductServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductRestControllerAdapter {
    private final IProductServicePort productServicePort;
    private final IProductRequestMapper productRequestMapper;
    private final IProductResponseMapper productResponseMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addProduct(@RequestBody AddProductRequest request) {
        productServicePort.saveProduct(productRequestMapper.addRequestToProduct(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productResponseMapper.
                toProductResponsesList(productServicePort.getAllProducts()));
    }
}
