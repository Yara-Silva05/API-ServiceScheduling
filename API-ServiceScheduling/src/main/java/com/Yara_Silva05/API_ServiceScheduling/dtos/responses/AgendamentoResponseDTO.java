package com.Yara_Silva05.API_ServiceScheduling.dtos.responses;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoResponseDTO(UUID agendamentoID,
                                     String email,
                                     String nome,
                                     String descricao,

                                     @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                     LocalDateTime inicioAgendamento,

                                     @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                     LocalDateTime encerramentoAgendamento) {
}
