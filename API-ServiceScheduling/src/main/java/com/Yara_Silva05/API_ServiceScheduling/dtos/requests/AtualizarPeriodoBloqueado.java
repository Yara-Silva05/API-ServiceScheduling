package com.Yara_Silva05.API_ServiceScheduling.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record AtualizarPeriodoBloqueado(@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                        LocalDateTime inicioBloqueio,
                                        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                        LocalDateTime encerramentoBloqueio,
                                        String razaoBloqueio) {
}
