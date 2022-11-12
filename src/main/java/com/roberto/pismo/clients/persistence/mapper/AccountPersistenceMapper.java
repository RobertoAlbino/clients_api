package com.roberto.pismo.clients.persistence.mapper;

import com.roberto.pismo.clients.business.model.AccountModel;
import com.roberto.pismo.clients.persistence.entities.AccountEntity;

public class AccountPersistenceMapper {

    public static AccountEntity toEntity(AccountModel model) {
        return AccountEntity
                .builder()
                    .documentNumber(model.getDocumentNumber())
                .build();
    }

    public static AccountModel toModel(AccountEntity entity) {
        return AccountModel
                .builder()
                    .id(entity.getId())
                    .documentNumber(entity.getDocumentNumber())
                .build();
    }
}
