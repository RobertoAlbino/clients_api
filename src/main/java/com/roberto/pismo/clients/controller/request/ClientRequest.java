package com.roberto.pismo.clients.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClientRequest {

    @JsonProperty("numero_documento")
    private Long documentNumber;

}
