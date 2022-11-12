package com.roberto.pismo.clients.persistence;

import com.roberto.pismo.clients.business.model.ClientModel;
import com.roberto.pismo.clients.persistence.mapper.ClientPersistenceMapper;
import com.roberto.pismo.clients.persistence.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientPersistence {

    private final ClientRepository repository;

    public ClientModel create(ClientModel client) {
        var entity = ClientPersistenceMapper.toEntity(client);
        var saved = repository.save(entity);
        return ClientPersistenceMapper.toModel(saved);
    }
}
