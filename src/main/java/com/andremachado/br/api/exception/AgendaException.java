package com.andremachado.br.api.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class AgendaException extends RuntimeException {

    public AgendaException(String message) {
        super(message);
    }

}
