package com.Yara_Silva05.API_ServiceScheduling.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UsuarioRequestDTO(@Pattern(regexp = "[A-Z]+(.)*")
                                @NotBlank
                                String nome,

                                @Email
                                @NotBlank
                                String email,

                                @NotBlank
                                String senha,

                                @NotBlank
                                String cargo) {
}
