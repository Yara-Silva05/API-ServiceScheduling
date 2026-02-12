package com.Yara_Silva05.API_ServiceScheduling.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record AtualizarPeriodoBloqueadoRequestDTO(@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                                  LocalDateTime inicioPeriodoBloqueado,

                                                  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                                  LocalDateTime encerramentoPeriodoBloqueado,

                                                  @NotBlank
                                                  String razaoBloqueio) {
}
