package com.andremachado.br.api.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class CpfException extends RuntimeException {

    public CpfException(String message) {
        super(message);
    }

}
