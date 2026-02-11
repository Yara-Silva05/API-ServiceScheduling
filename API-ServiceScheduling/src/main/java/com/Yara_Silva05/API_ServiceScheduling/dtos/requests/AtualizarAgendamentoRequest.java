package com.Yara_Silva05.API_ServiceScheduling.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record AtualizarAgendamentoRequest(@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                          LocalDateTime inicioAgendamento,
                                          @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                          LocalDateTime encerramentoAgendamento) {
}
