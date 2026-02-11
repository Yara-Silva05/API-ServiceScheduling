package com.Yara_Silva05.API_ServiceScheduling.controllers;

import com.Yara_Silva05.API_ServiceScheduling.dtos.requests.AtualizarUsuarioRequestDTO;
import com.Yara_Silva05.API_ServiceScheduling.dtos.requests.UsuarioRequestDTO;
import com.Yara_Silva05.API_ServiceScheduling.dtos.responses.UsuarioResponseDTO;
import com.Yara_Silva05.API_ServiceScheduling.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criarUsuario (@RequestBody @Valid UsuarioRequestDTO body){
         return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criarUsuario(body));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> buscarTodosUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarTodosUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarUsuarioPorId (@PathVariable(value = "id")UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarUsuarioPorID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizarUsuario (@PathVariable(value = "id")UUID id,
                                                                @RequestBody @Valid AtualizarUsuarioRequestDTO body) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.atualizarUsuario(id, body));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuario (@PathVariable UUID id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso!");
    }
}
