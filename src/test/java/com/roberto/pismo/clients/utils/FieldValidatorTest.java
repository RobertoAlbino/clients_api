package com.roberto.pismo.clients.utils;

import com.roberto.pismo.clients.exceptions.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FieldValidatorTest {

    @Test
    void assertValidateNullThrows() {
        Assertions.assertThrows(BusinessException.class,
                () -> FieldValidator.validateNull(null, "testField"),
                FieldValidator.buildMessage("testField"));
    }

}