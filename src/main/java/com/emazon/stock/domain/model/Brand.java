package com.emazon.stock.domain.model;

import com.emazon.stock.domain.exception.EmptyFieldException;
import com.emazon.stock.domain.exception.NegativeNotAllowedException;
import com.emazon.stock.domain.util.DomainConstants;

import static java.util.Objects.requireNonNull;

public class Brand {
    private final Long id;
    private final String name;
    private final String description;

    public Brand(Long id, String name, String description) {
        //Restrictions
        if (name.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }
        if (name.length() > 50) {
            throw new NegativeNotAllowedException(DomainConstants.Field.NAME.toString());
        }
        if (description.length() > 120) {
            throw new NegativeNotAllowedException(DomainConstants.Field.DESCRIPTION.toString());
        }

        this.id = id;
        this.name = requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.description = requireNonNull(description, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
