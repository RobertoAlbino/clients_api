package com.roberto.pismo.clients.persistence;

import com.roberto.pismo.clients.business.model.AccountModel;
import com.roberto.pismo.clients.exceptions.BusinessException;
import com.roberto.pismo.clients.persistence.mapper.AccountPersistenceMapper;
import com.roberto.pismo.clients.persistence.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountPersistence {

    public final String DOCUMENT_NUMBER_DUPLICATED = "Já existe uma conta utilizando o documento informado";
    public final String ACCOUNT_NOT_FOUND = "A conta não foi encontrada";

    private final AccountRepository repository;

    public AccountModel findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new BusinessException(ACCOUNT_NOT_FOUND));
        return AccountPersistenceMapper.toModel(entity);
    }

    public AccountModel create(AccountModel client) {
        var entity = AccountPersistenceMapper.toEntity(client);
        var saved = repository.save(entity);
        return AccountPersistenceMapper.toModel(saved);
    }

    public void throwExistsByDocumentNumber(Long documentNumber) {
        var duplicate = repository.existsAccountEntityByDocumentNumber(documentNumber);
        if (duplicate) {
            throw new BusinessException(DOCUMENT_NUMBER_DUPLICATED);
        }
    }
}
