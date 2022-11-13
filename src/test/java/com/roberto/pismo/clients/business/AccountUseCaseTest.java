package com.roberto.pismo.clients.business;

import com.roberto.pismo.clients.business.model.AccountModel;
import com.roberto.pismo.clients.business.validator.CreateAccountValidator;
import com.roberto.pismo.clients.persistence.AccountPersistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AccountUseCaseTest {

    @InjectMocks
    AccountUseCase accountUseCase;

    @Mock
    AccountPersistence accountPersistence;

    @Mock
    CreateAccountValidator createAccountValidator;

    @Test
    void assertFindByIdDoesNotThrows() {
        Assertions.assertDoesNotThrow(() -> accountUseCase.findById(1L));
    }

    @Test
    void assertCreateDoesNotThrows() {
        var model = AccountModel.builder().documentNumber(123L).build();
        Assertions.assertDoesNotThrow(() -> accountUseCase.create(model));
    }
}