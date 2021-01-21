package com.microservicos.compras.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DadosInvalidosException extends ResponseStatusException {

    public DadosInvalidosException(String msg){
        super(HttpStatus.BAD_REQUEST, msg);
    }
}
