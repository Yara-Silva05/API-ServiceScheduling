package com.Yara_Silva05.API_ServiceScheduling.dtos.responses;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoResponseDTO(UUID agendamentoID,
                                     String email,
                                     String nome,
                                     String descricao,
                                     LocalDateTime inicioAgendamento,
                                     LocalDateTime encerramentoAgendamento) {
}
