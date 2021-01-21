package com.microservicos.produtos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ProdutoNaoEncontradoException extends ResponseStatusException {

    public ProdutoNaoEncontradoException(String msg){
        super(HttpStatus.NOT_FOUND, msg);
    }
}
