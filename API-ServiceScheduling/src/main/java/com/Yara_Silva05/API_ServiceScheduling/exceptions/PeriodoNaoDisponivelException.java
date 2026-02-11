package com.Yara_Silva05.API_ServiceScheduling.exceptions;

public class PeriodoNaoDisponivelException extends RuntimeException {
    public PeriodoNaoDisponivelException() {
        super("Período de agendamento indisponível.");
    }
}
