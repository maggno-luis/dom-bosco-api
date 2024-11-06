package br.com.dev.api_service.exceptions;

public class EmailExistException extends RuntimeException{

    public EmailExistException() {
        super("Email já está em uso");
    }
    public EmailExistException(String message) {
        super(message);
    }
}
