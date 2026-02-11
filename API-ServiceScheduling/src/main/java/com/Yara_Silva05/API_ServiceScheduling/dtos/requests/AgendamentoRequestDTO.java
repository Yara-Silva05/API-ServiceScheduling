package com.Yara_Silva05.API_ServiceScheduling.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoRequestDTO(@NotNull
                                    UUID idUsuario,

                                    @NotBlank
                                    String descricao,

                                    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                    LocalDateTime inicioAgendamento,

                                    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                    LocalDateTime encerramentoAgendamento) {
}
