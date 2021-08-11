package com.andremachado.br.api.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnableToVoteException extends RuntimeException {

    public UnableToVoteException(String message) {
        super(message);
    }

}
