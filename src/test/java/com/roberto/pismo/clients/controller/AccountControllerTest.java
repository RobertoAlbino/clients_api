package com.roberto.pismo.clients.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roberto.pismo.clients.business.AccountUseCase;
import com.roberto.pismo.clients.business.model.AccountModel;
import com.roberto.pismo.clients.business.validator.CreateAccountValidator;
import com.roberto.pismo.clients.controller.request.AccountRequest;
import com.roberto.pismo.clients.persistence.AccountPersistence;
import com.roberto.pismo.clients.persistence.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = AccountController.class)
class AccountControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    AccountUseCase accountUseCase;

    @MockBean
    AccountPersistence accountPersistence;

    @MockBean
    CreateAccountValidator createAccountValidator;


    @Test
    void testFindByIdEndpoint() throws Exception {
        when(accountUseCase.findById(1L)).thenReturn(AccountModel.builder().build());
        MockHttpServletResponse response = mvc.perform(get("/accounts/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());

    }

    @Test
    void testCreateEndpoint() throws Exception {

        when(accountUseCase.create(any())).thenReturn(AccountModel.builder().build());

        var request = AccountRequest.builder().documentNumber(123L).build();

        MockHttpServletResponse response = mvc.perform(post("/accounts")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON_VALUE).characterEncoding("UTF-8")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());

    }

}