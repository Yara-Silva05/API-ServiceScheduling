package com.Yara_Silva05.API_ServiceScheduling.controllers;

import com.Yara_Silva05.API_ServiceScheduling.dtos.requests.AgendamentoRequestDTO;
import com.Yara_Silva05.API_ServiceScheduling.dtos.requests.AtualizarAgendamentoRequest;
import com.Yara_Silva05.API_ServiceScheduling.dtos.responses.AgendamentoResponseDTO;
import com.Yara_Silva05.API_ServiceScheduling.services.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoResponseDTO> criarAgendamento(@RequestBody @Valid AgendamentoRequestDTO body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoService.criarAgendamento(body));
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponseDTO>> buscarTodosAgendamentos() {
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoService.buscarTodosAgendamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponseDTO> buscarAgendamentoPorID(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoService.buscarAgendamentoPorID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoResponseDTO> atualizarUsuario (@PathVariable(value = "id")UUID id,
                                                                @RequestBody @Valid AtualizarAgendamentoRequest body) {
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoService.atualizarAgendamento(id, body));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAgendamento(@PathVariable UUID id) {
        agendamentoService.deletarAgendamento(id);
        return ResponseEntity.status(HttpStatus.OK).body("Agendamento deletado com sucesso!.");
    }
}
