package com.roberto.pismo.clients.persistence;

import com.roberto.pismo.clients.business.model.AccountModel;
import com.roberto.pismo.clients.exceptions.BusinessException;
import com.roberto.pismo.clients.persistence.entities.AccountEntity;
import com.roberto.pismo.clients.persistence.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountPersistenceTest {

    @InjectMocks
    AccountPersistence accountPersistence;

    @Mock
    AccountRepository accountRepository;

    @Test
    void assertFindByIdDoesNotThrows() {
        when(accountRepository.findById(any())).thenReturn(Optional.of(AccountEntity.builder().build()));
        accountPersistence.findById(1L);
    }

    @Test
    void assertFindByIdThrows() {
        when(accountRepository.findById(any())).thenReturn(Optional.empty());
        Assertions.assertThrows(BusinessException.class,
                () -> accountPersistence.findById(1L),
                accountPersistence.ACCOUNT_NOT_FOUND);
    }

    @Test
    void assertCreateDoesNotThrows() {
        when(accountRepository.save(any())).thenReturn(AccountEntity.builder().build());
        var model = AccountModel.builder().build();
        Assertions.assertDoesNotThrow(() -> accountPersistence.create(model));
    }

    @Test
    void assertThrowExistsByDocumentNumberThrows() {
        when(accountRepository.existsAccountEntityByDocumentNumber(any())).thenReturn(true);
        Assertions.assertThrows(BusinessException.class,
                () -> accountPersistence.throwExistsByDocumentNumber(1L),
                accountPersistence.DOCUMENT_NUMBER_DUPLICATED);
    }
}