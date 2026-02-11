package com.Yara_Silva05.API_ServiceScheduling.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoRequestDTO(@NotBlank
                                    UUID idUsuario,

                                    @NotBlank
                                    String descricao,

                                    @NotBlank
                                    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                    LocalDateTime inicioAgendamento,

                                    @NotBlank
                                    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                    LocalDateTime encerramentoAgendamento) {
}
