package com.roberto.pismo.clients.business.validator;

import com.roberto.pismo.clients.business.model.AccountModel;
import com.roberto.pismo.clients.persistence.AccountPersistence;
import com.roberto.pismo.clients.utils.FieldValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAccountValidator {

    private final AccountPersistence accountPersistence;

    private void validateFields(AccountModel client) {
        FieldValidator.validateNull(client.getDocumentNumber(), "documentNumber");
    }

    public void validateCreate(AccountModel client) {
        validateFields(client);
        accountPersistence.throwExistsByDocumentNumber(client.getDocumentNumber());
    }

}
