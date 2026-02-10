package com.Yara_Silva05.API_ServiceScheduling.dtos.requests;

import java.time.LocalDateTime;

public record AtualizarAgendamentoResquest(LocalDateTime inicioAgendamento,
                                           LocalDateTime encerramentoAgendamento) {
}
