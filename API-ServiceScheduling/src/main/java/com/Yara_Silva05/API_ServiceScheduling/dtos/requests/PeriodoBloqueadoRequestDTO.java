package com.Yara_Silva05.API_ServiceScheduling.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public record PeriodoBloqueadoRequestDTO(UUID idUsuarioResponsavel,
                                         @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                         LocalDateTime inicioPeriodoBloqueio,
                                         @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                         LocalDateTime finalPeriodoBloqueio,
                                         String razaoBloqueio) {
}
