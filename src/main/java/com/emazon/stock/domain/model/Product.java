package com.emazon.stock.domain.model;

import com.emazon.stock.domain.exception.EmptyFieldException;
import com.emazon.stock.domain.exception.NegativeNotAllowedException;
import com.emazon.stock.domain.exception.SizeNotAllowedException;
import com.emazon.stock.domain.util.DomainConstants;

import java.math.BigDecimal;
import java.util.List;

public class Product {
    private final Long id;
    private final String name;
    private final String description;
    private final Integer quantity;
    private final BigDecimal price;
    private Brand brand;
    private List<Category> categories;

    public Product(Long id, String name, String description, Integer quantity, BigDecimal price) {
        //Restrictions
        if (name.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new NegativeNotAllowedException(DomainConstants.Field.PRICE.toString());
        }
        if (quantity < 0) {
            throw new NegativeNotAllowedException(DomainConstants.Field.QUANTITY.toString());
        }

        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setCategories(List<Category> categories) {
        if (categories.size() < 1 || categories.size() > 3) {
            throw new SizeNotAllowedException(DomainConstants.Field.CATEGORIES.toString());
        }
        this.categories = categories;
    }
}
