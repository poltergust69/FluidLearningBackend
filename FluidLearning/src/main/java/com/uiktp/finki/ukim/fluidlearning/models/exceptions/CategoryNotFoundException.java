package com.uiktp.finki.ukim.fluidlearning.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(int id) {
        super(String.format("Could not find a category with this id: %d", id));
    }
}
