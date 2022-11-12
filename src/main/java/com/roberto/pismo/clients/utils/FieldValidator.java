package com.roberto.pismo.clients.utils;

import com.roberto.pismo.clients.exceptions.BusinessException;

import java.util.Objects;

public class FieldValidator {

    public static void validateNull(Object field, String fieldName) {
        if (Objects.isNull(field)) {
            var message = String.format("O campo %s não pode ser nulo", fieldName);
            throw new BusinessException(message);
        }
    }

}
