package com.emazon.stock.domain.model;

import com.emazon.stock.domain.exception.EmptyFieldException;
import com.emazon.stock.domain.exception.NegativeNotAllowedException;
import com.emazon.stock.domain.util.DomainConstants;

import static java.util.Objects.requireNonNull;

public class Category {
    private final Long id;
    private final String name;
    private final String description;

    public Category(Long id, String name, String description) {
        //Restrictions
        if (name.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }
        if (name.length() > 50) {
            throw new NegativeNotAllowedException(DomainConstants.Field.NAME.toString());
        }
        if (description.length() > 90) {
            throw new NegativeNotAllowedException(DomainConstants.Field.DESCRIPTION.toString());
        }

        //Assignments
        this.id = id;
        this.name = requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.description = requireNonNull(description, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
