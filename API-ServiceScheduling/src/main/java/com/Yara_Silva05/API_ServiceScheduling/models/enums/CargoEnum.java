package com.Yara_Silva05.API_ServiceScheduling.models.enums;

public enum CargoEnum {
    USUARIO("Usuário"),
    ADMIN("Administrador");

   private String cargoRelatorio;

    CargoEnum(String cargoRelatorio) {
        this.cargoRelatorio = cargoRelatorio;
    }
}
