package br.com.dev.api_service.exceptions;

public class EmailInvalidException extends RuntimeException{

    public EmailInvalidException() {
        super();
    }
    public EmailInvalidException(String message) {
        super(message);
    }
}
