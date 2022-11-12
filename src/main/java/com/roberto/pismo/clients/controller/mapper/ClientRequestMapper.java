package com.roberto.pismo.clients.controller.mapper;

import com.roberto.pismo.clients.business.model.ClientModel;
import com.roberto.pismo.clients.controller.request.ClientRequest;

public class ClientRequestMapper {

    public static ClientModel toModel(ClientRequest request) {
        return ClientModel
                .builder()
                    .documentNumber(request.getDocumentNumber())
                .build();
    }
}
