package com.roberto.pismo.clients.business.validator;

import com.roberto.pismo.clients.business.model.ClientModel;
import com.roberto.pismo.clients.utils.FieldValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateClientValidator {

    private void validateFields(ClientModel client) {
        FieldValidator.validateNull(client.getDocumentNumber(), "documentNumber");
    }

    public void validateCreate(ClientModel client) {
        validateFields(client);
    }
}
