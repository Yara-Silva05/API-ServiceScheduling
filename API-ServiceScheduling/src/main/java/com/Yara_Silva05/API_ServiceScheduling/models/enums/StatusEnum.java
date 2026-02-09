package com.Yara_Silva05.API_ServiceScheduling.models.enums;

public enum StatusEnum {
    AGENDADO("Agendado"),
    CONFIRMADO("Confirmado"),
    CANCELADO("Cancelado");

    private String statusRelatorio;

    StatusEnum(String statusRelatorio) {
        this.statusRelatorio = statusRelatorio;
    }

    public String getStatusRelatorio() {
        return statusRelatorio;
    }
}
