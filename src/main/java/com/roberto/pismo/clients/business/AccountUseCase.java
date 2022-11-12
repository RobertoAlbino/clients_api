package com.roberto.pismo.clients.business;

import com.roberto.pismo.clients.business.model.AccountModel;
import com.roberto.pismo.clients.business.validator.CreateAccountValidator;
import com.roberto.pismo.clients.persistence.AccountPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountUseCase {

    private final AccountPersistence accountPersistence;
    private final CreateAccountValidator createAccountValidator;

    public AccountModel findById(Long id) {
        return accountPersistence.findById(id);
    }

    public AccountModel create(AccountModel client) {
        createAccountValidator.validateCreate(client);
        return accountPersistence.create(client);
    }
}
