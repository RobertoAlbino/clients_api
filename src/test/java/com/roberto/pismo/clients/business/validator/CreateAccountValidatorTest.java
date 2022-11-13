package com.roberto.pismo.clients.business.validator;

import com.roberto.pismo.clients.business.model.AccountModel;
import com.roberto.pismo.clients.exceptions.BusinessException;
import com.roberto.pismo.clients.persistence.AccountPersistence;
import com.roberto.pismo.clients.utils.FieldValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class CreateAccountValidatorTest {

    @InjectMocks
    CreateAccountValidator createAccountValidator;

    @Mock
    AccountPersistence accountPersistence;

    @Test
    void assertThrowsWhenDocumentNumberIsNull() {
        var model = AccountModel.builder().build();
        Assertions.assertThrows(BusinessException.class,
                () -> createAccountValidator.validateCreate(model),
                FieldValidator.buildMessage("documentNumber"));
    }

    @Test
    void assertThrowsWhenDocumentNumberIsDuplicated() {
        var model = AccountModel.builder().documentNumber(123L).build();
        doThrow(new BusinessException(accountPersistence.DOCUMENT_NUMBER_DUPLICATED))
            .when(accountPersistence)
            .throwExistsByDocumentNumber(any());
        Assertions.assertThrows(BusinessException.class,
                () -> createAccountValidator.validateCreate(model),
                accountPersistence.DOCUMENT_NUMBER_DUPLICATED);
    }

    @Test
    void assertDoesNotThrowsWhenDocumentNumberIsNotDuplicated() {
        var model = AccountModel.builder().documentNumber(123L).build();
        Assertions.assertDoesNotThrow(() -> createAccountValidator.validateCreate(model));
    }

}