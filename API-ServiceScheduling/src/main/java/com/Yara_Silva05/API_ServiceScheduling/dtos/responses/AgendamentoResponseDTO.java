package com.Yara_Silva05.API_ServiceScheduling.dtos.responses;

import java.time.LocalDateTime;

public record AgendamentoResponseDTO(String email,
                                     String nome,
                                     String descricao,
                                     LocalDateTime inicioAgendamento,
                                     LocalDateTime encerramentoAgendamento) {
}
