package br.com.dev.api_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEmailAndPasswordException extends RuntimeException{

    public InvalidEmailAndPasswordException() {
        super("Email ou senha inválidos");
    }
    public InvalidEmailAndPasswordException(String message) {
        super(message);
    }
}
