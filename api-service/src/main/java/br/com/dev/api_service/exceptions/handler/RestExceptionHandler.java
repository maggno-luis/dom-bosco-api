package br.com.dev.api_service.exceptions.handler;

import br.com.dev.api_service.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmailExistException.class)
    private ResponseEntity<RestErrorMessage> emailExistException(EmailExistException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.CONFLICT.value(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(InvalidEmailAndPasswordException.class)
    private ResponseEntity<RestErrorMessage> invalidEmailAndPasswordException(InvalidEmailAndPasswordException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(PasswordInvalidException.class)
    private ResponseEntity<RestErrorMessage> passwordInvalidException(PasswordInvalidException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    @ExceptionHandler(EmailInvalidException.class)
    private ResponseEntity<RestErrorMessage> emailInvalidException(EmailInvalidException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    @ExceptionHandler(AccessDeniedException.class)
    private ResponseEntity<RestErrorMessage> accessException(AccessDeniedException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.FORBIDDEN.value(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @ExceptionHandler(BadCredentialsException.class)
    private ResponseEntity<RestErrorMessage> accessException(BadCredentialsException exception){
        RestErrorMessage response = new RestErrorMessage(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}


