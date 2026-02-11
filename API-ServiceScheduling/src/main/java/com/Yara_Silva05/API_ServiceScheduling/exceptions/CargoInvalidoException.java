package com.Yara_Silva05.API_ServiceScheduling.exceptions;

public class CargoInvalidoException extends RuntimeException {
    public CargoInvalidoException() {
        super("Cargo invalido. Cargos válidos: usuario, admin.");
    }
}
