package com.roberto.pismo.clients.controller.mapper;

import com.roberto.pismo.clients.business.model.AccountModel;
import com.roberto.pismo.clients.controller.request.AccountRequest;
import com.roberto.pismo.clients.controller.response.AccountResponse;

public class AccountRequestMapper {

    public static AccountModel toModel(AccountRequest request) {
        return AccountModel
                .builder()
                    .documentNumber(request.getDocumentNumber())
                .build();
    }

    public static AccountResponse toResponse(AccountModel model) {
        return AccountResponse
                .builder()
                    .accountID(model.getId())
                    .documentNumber(model.getDocumentNumber())
                .build();
    }
}
