package com.Yara_Silva05.API_ServiceScheduling.exceptions;

public class EmailExistenteException extends RuntimeException{
    public EmailExistenteException() {
        super("Email já cadastrado.");
    }
}
