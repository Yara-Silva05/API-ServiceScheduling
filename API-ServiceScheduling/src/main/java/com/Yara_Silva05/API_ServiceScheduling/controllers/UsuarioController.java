package com.Yara_Silva05.API_ServiceScheduling.controllers;

import com.Yara_Silva05.API_ServiceScheduling.dtos.UsuarioRequestDTO;
import com.Yara_Silva05.API_ServiceScheduling.dtos.UsuarioResponseDTO;
import com.Yara_Silva05.API_ServiceScheduling.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criarUsuario(@RequestBody @Valid UsuarioRequestDTO body){
         return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criarUsuario(body));
    }
}
