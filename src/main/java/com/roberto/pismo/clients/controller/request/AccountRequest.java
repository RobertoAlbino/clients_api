package com.roberto.pismo.clients.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountRequest {

    @JsonProperty("document_number")
    private Long documentNumber;

}
