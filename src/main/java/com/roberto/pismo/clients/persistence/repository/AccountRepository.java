package com.roberto.pismo.clients.persistence.repository;

import com.roberto.pismo.clients.persistence.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    boolean existsAccountEntityByDocumentNumber(Long documentNumber);

}
