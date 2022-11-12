package com.roberto.pismo.clients.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountResponse {

    @JsonProperty("account_id")
    private Long accountID;

    @JsonProperty("document_number")
    private Long documentNumber;

}
