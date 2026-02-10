package com.Yara_Silva05.API_ServiceScheduling.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoRequestDTO(UUID idUsuario,
                                    String descricao,
                                    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                    LocalDateTime inicioAgendamento,
                                    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                    LocalDateTime encerramentoAgendamento) {
}
