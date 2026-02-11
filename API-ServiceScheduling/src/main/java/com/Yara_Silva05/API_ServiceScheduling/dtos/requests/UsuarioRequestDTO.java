package com.Yara_Silva05.API_ServiceScheduling.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDTO(@NotBlank
                                String nome,

                                @Email
                                @NotBlank
                                String email,

                                @NotBlank
                                String senha,

                                @NotBlank
                                String cargo) {

}
