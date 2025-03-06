package com.polarbookshop.catalogservice.domain;


import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import static org.assertj.core.api.Assertions.assertThat;

public class BookValidationTests {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void whenAllFieldsCorrectThenValidationSucceeds() {
        var book = new Book(null, "1234567890", "Title", "Author", 9.90, null, null, 0);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
    }

    @Test
    void whenIsbnDefinedButIncorrecThenValidationFails() {
        var book = new Book(null, "ab34567890", "Title", "Author", 9.90, null, null, 0);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage())
            .isEqualTo("The ISBN format must be valid.");
    }

}
