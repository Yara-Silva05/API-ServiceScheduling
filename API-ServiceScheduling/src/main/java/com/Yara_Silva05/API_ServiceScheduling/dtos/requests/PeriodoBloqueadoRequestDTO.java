package com.Yara_Silva05.API_ServiceScheduling.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record PeriodoBloqueadoRequestDTO(@NotNull
                                         UUID idUsuarioResponsavel,

                                         @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                         LocalDateTime inicioPeriodoBloqueio,

                                         @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                         LocalDateTime finalPeriodoBloqueio,

                                         @NotBlank
                                         String razaoBloqueio) {
}
