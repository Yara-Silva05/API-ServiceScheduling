package com.Yara_Silva05.API_ServiceScheduling.controllers;

import com.Yara_Silva05.API_ServiceScheduling.dtos.requests.AtualizarAgendamentoRequest;
import com.Yara_Silva05.API_ServiceScheduling.dtos.requests.AtualizarPeriodoBloqueado;
import com.Yara_Silva05.API_ServiceScheduling.dtos.requests.PeriodoBloqueadoRequestDTO;
import com.Yara_Silva05.API_ServiceScheduling.dtos.responses.AgendamentoResponseDTO;
import com.Yara_Silva05.API_ServiceScheduling.dtos.responses.PeriodoBloqueadoResponseDTO;
import com.Yara_Silva05.API_ServiceScheduling.services.PeriodoBloqueadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/horarioBloqueado")
public class PeriodoBloqueadoController {

    @Autowired
    private PeriodoBloqueadoService periodoBloqueadoService;

    @PostMapping
    public ResponseEntity<PeriodoBloqueadoResponseDTO> bloquearPeriodo(@RequestBody PeriodoBloqueadoRequestDTO body) {
        return ResponseEntity.status(HttpStatus.OK).body(periodoBloqueadoService.criarPeriodoBloqueado(body));
    }

    @GetMapping
    public ResponseEntity<List<PeriodoBloqueadoResponseDTO>> buscarTodosPeriodosBloqueados() {
        return ResponseEntity.status(HttpStatus.OK).body(periodoBloqueadoService.buscarTodosPeriodoBloqueados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodoBloqueadoResponseDTO> buscarPeriodoBloqueadoPorID(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(periodoBloqueadoService.buscarPeriodoBloqueadoPorID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeriodoBloqueadoResponseDTO> atualizarPeriodoBloqueado(@PathVariable(value = "id")UUID id,
                                                                    @RequestBody @Valid AtualizarPeriodoBloqueado body) {
        return ResponseEntity.status(HttpStatus.OK).body(periodoBloqueadoService.atualizarPeriodoBloqueado(id, body));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPeriodoBloqueado(@PathVariable UUID id) {
        periodoBloqueadoService.deletarPeriodoBloqueado(id);
        return ResponseEntity.status(HttpStatus.OK).body("Agendamento deletado com sucesso!.");
    }
}
