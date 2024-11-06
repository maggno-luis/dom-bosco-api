package br.com.dev.api_service.exceptions;

public class PasswordInvalidException extends RuntimeException{

    public PasswordInvalidException() {
        super();
    }
    public PasswordInvalidException(String message) {
        super(message);
    }
}
