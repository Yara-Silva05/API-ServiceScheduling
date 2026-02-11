package com.Yara_Silva05.API_ServiceScheduling.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

public record PeriodoBloqueadoRequestDTO(@NotBlank
                                         UUID idUsuarioResponsavel,

                                         @NotBlank
                                         @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                         LocalDateTime inicioPeriodoBloqueio,

                                         @NotBlank
                                         @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                         LocalDateTime finalPeriodoBloqueio,

                                         @NotBlank
                                         String razaoBloqueio) {
}
