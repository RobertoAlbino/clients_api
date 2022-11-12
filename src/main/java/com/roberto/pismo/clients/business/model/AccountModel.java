package com.roberto.pismo.clients.business.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountModel {

    private Long id;

    private Long documentNumber;

}
