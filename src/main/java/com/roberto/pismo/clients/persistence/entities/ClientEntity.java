package com.roberto.pismo.clients.persistence.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Accounts")
@Builder
@Data
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Account_ID", nullable = false)
    private Long id;

    @Column(name = "Document_Number", nullable = false)
    private Long documentNumber;

}
