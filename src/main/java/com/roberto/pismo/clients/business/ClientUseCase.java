package com.roberto.pismo.clients.business;

import com.roberto.pismo.clients.business.model.ClientModel;
import com.roberto.pismo.clients.business.validator.CreateClientValidator;
import com.roberto.pismo.clients.persistence.ClientPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientUseCase {

    private final ClientPersistence clientPersistence;
    private final CreateClientValidator createClientValidator;

    public ClientModel create(ClientModel client) {
        createClientValidator.validateCreate(client);
        return clientPersistence.create(client);
    }
}
