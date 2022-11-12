package com.roberto.pismo.clients.controller;

import com.roberto.pismo.clients.controller.mapper.AccountRequestMapper;
import com.roberto.pismo.clients.controller.request.AccountRequest;
import com.roberto.pismo.clients.business.AccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("accounts")
public class AccountController {

    private final AccountUseCase accountUseCase;

    @GetMapping(path = "/{account_id}")
    public ResponseEntity findById(@PathVariable("account_id") Long id) {
        var client = accountUseCase.findById(id);
        return ResponseEntity.ok(AccountRequestMapper.toResponse(client));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody AccountRequest request) {
        var model = AccountRequestMapper.toModel(request);
        var client = accountUseCase.create(model);
        return ResponseEntity.ok(AccountRequestMapper.toResponse(client));
    }

}
