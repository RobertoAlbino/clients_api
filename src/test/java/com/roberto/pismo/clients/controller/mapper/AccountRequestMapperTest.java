package com.roberto.pismo.clients.controller.mapper;

import com.roberto.pismo.clients.business.model.AccountModel;
import com.roberto.pismo.clients.controller.request.AccountRequest;
import com.roberto.pismo.clients.controller.response.AccountResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountRequestMapperTest {

    @Test
    void testToModel() {
        var request = AccountRequest.builder().documentNumber(123L).build();
        var model = AccountRequestMapper.toModel(request);
        assertEquals(123L, model.getDocumentNumber());
    }

    @Test
    void testToResponse() {
        var model = AccountModel.builder().documentNumber(123L).build();
        var response = AccountRequestMapper.toResponse(model);
        assertEquals(123L, response.getDocumentNumber());
    }

}