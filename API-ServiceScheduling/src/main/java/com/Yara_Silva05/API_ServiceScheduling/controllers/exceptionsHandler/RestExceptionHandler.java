package com.Yara_Silva05.API_ServiceScheduling.controllers.exceptionsHandler;

import com.Yara_Silva05.API_ServiceScheduling.exceptions.EmailExistenteException;
import com.Yara_Silva05.API_ServiceScheduling.exceptions.EntidadeNaoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    private ResponseEntity<String> usuarioNaoEncontradoHandler(EntidadeNaoEncontradaException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(EmailExistenteException.class)
    private ResponseEntity<String> emailExistenteHandler(EmailExistenteException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<String> excecaoGenericaHandler(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado: " + exception.getMessage());
    }
}