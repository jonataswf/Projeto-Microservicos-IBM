package com.microservicos.compras.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NaoEncontradaException extends ResponseStatusException {

    public NaoEncontradaException(String msg){
        super(HttpStatus.NOT_FOUND, msg);
    }
}
