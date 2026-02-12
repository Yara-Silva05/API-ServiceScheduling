package com.Yara_Silva05.API_ServiceScheduling.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record AtualizarAgendamentoRequestDTO(@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                             LocalDateTime inicioAgendamento,

                                             @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                             LocalDateTime encerramentoAgendamento,

                                             @NotBlank
                                             String descricao){

}
