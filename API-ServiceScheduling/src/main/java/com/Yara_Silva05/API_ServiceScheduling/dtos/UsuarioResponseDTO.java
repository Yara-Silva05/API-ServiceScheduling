package com.Yara_Silva05.API_ServiceScheduling.dtos;

import java.util.UUID;

public record UsuarioResponseDTO(UUID id,
                                 String nome,
                                 String email,
                                 String cargo) {
}
