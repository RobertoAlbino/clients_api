package com.roberto.pismo.clients.persistence.mapper;

import com.roberto.pismo.clients.business.model.AccountModel;
import com.roberto.pismo.clients.persistence.entities.AccountEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AccountPersistenceMapperTest {

    @Test
    void mapToEntity() {
        var model = AccountModel.builder().documentNumber(123L).build();
        var entity = AccountPersistenceMapper.toEntity(model);
        Assertions.assertEquals(123L, entity.getDocumentNumber());
    }

    @Test
    void mapToModel() {
        var entity = AccountEntity.builder().documentNumber(123L).build();
        var model = AccountPersistenceMapper.toModel(entity);
        Assertions.assertEquals(123L, model.getDocumentNumber());
    }
}