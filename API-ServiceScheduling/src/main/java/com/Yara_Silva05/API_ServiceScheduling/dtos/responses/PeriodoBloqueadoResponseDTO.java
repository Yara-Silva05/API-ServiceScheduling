package com.Yara_Silva05.API_ServiceScheduling.dtos.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record PeriodoBloqueadoResponseDTO(String email,
                                          String nome,
                                          String razaoBloqueio,
                                          @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                          LocalDateTime inicioPeriodoBloqueio,
                                          @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                          LocalDateTime finalPeriodoBloqueio ) {
}
