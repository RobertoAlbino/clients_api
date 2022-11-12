package com.roberto.pismo.clients.persistence.mapper;

import com.roberto.pismo.clients.business.model.ClientModel;
import com.roberto.pismo.clients.persistence.entities.ClientEntity;

public class ClientPersistenceMapper {

    public static ClientEntity toEntity(ClientModel model) {
        return ClientEntity
                .builder()
                    .documentNumber(model.getDocumentNumber())
                .build();
    }

    public static ClientModel toModel(ClientEntity entity) {
        return ClientModel
                .builder()
                    .id(entity.getId())
                    .documentNumber(entity.getDocumentNumber())
                .build();
    }
}
