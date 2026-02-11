package com.Yara_Silva05.API_ServiceScheduling.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AtualizarUsuarioRequestDTO(@NotBlank
                                          String nome,

                                          @Email
                                          String email) {

}
