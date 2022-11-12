package com.roberto.pismo.clients.controller;

import com.roberto.pismo.clients.controller.mapper.ClientRequestMapper;
import com.roberto.pismo.clients.controller.request.ClientRequest;
import com.roberto.pismo.clients.business.ClientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientUseCase clientUseCase;

    @PostMapping
    public ResponseEntity create(@RequestBody ClientRequest request) {
        var model = ClientRequestMapper.toModel(request);
        var entity = clientUseCase.create(model);
        return ResponseEntity.ok(entity);
    }

}
