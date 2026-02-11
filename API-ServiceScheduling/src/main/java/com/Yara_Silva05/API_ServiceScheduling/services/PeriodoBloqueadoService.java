package com.Yara_Silva05.API_ServiceScheduling.services;

import com.Yara_Silva05.API_ServiceScheduling.dtos.requests.AtualizarPeriodoBloqueado;
import com.Yara_Silva05.API_ServiceScheduling.dtos.requests.PeriodoBloqueadoRequestDTO;
import com.Yara_Silva05.API_ServiceScheduling.dtos.responses.PeriodoBloqueadoResponseDTO;
import com.Yara_Silva05.API_ServiceScheduling.exceptions.EntidadeNaoEncontradaException;
import com.Yara_Silva05.API_ServiceScheduling.models.PeriodoBloqueadoModel;
import com.Yara_Silva05.API_ServiceScheduling.models.UsuarioModel;
import com.Yara_Silva05.API_ServiceScheduling.repositories.PeriodoBloqueadoRepository;
import com.Yara_Silva05.API_ServiceScheduling.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PeriodoBloqueadoService {

    @Autowired
    private PeriodoBloqueadoRepository periodoBloqueadoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //POST
    @Transactional
    public PeriodoBloqueadoResponseDTO criarPeriodoBloqueado(PeriodoBloqueadoRequestDTO body){

        Optional<UsuarioModel> usuario = usuarioRepository.findById(body.idUsuarioResponsavel());
        if (usuario.isPresent()) {
            PeriodoBloqueadoModel periodoBloqueado = new PeriodoBloqueadoModel(
                    body.inicioPeriodoBloqueio(),
                    body.finalPeriodoBloqueio(),
                    usuario.get(),
                    body.razaoBloqueio());

            periodoBloqueadoRepository.save(periodoBloqueado);

            return converterPeriodoBloqueadoParaResponseDTO(periodoBloqueado, usuario.get());
        }
        else {
            throw new EntidadeNaoEncontradaException("Usuário não encontrado");
        }
    }

    //GET ALL
    public List<PeriodoBloqueadoResponseDTO> buscarTodosPeriodoBloqueados() {

        List<PeriodoBloqueadoModel> periodosBloqueados = periodoBloqueadoRepository.findAll();

        List<PeriodoBloqueadoResponseDTO> dtos = new ArrayList<>();

        for (PeriodoBloqueadoModel periodoBloqueado: periodosBloqueados) {
            dtos.add(converterPeriodoBloqueadoParaResponseDTO(periodoBloqueado,buscarUsuarioPorPeriodoBloqueado(periodoBloqueado)));
        }
        return dtos;
    }

    //GET BY ID
    public PeriodoBloqueadoResponseDTO buscarPeriodoBloqueadoPorID(UUID id){

        Optional<PeriodoBloqueadoModel> periodoBloqueado = periodoBloqueadoRepository.findById(id);

        if (periodoBloqueado.isPresent()) {
            return converterPeriodoBloqueadoParaResponseDTO(periodoBloqueado.get(), buscarUsuarioPorPeriodoBloqueado(periodoBloqueado.get()));
        } else {
            throw new EntidadeNaoEncontradaException("Agendamento não encontrado");
        }
    }

    //PUT BY ID
    public PeriodoBloqueadoResponseDTO atualizarPeriodoBloqueado(UUID id, AtualizarPeriodoBloqueado body){
        Optional<PeriodoBloqueadoModel> periodoBloqueado = periodoBloqueadoRepository.findById(id);

        if (periodoBloqueado.isPresent()) {

            periodoBloqueado.get().setInicioPeriodoBloqueio(body.inicioBloqueio());
            periodoBloqueado.get().setFinalPeriodoBloqueio(body.encerramentoBloqueio());
            periodoBloqueado.get().setRazaoBloqueio(body.razaoBloqueio());

            periodoBloqueadoRepository.save(periodoBloqueado.get());

            return converterPeriodoBloqueadoParaResponseDTO(periodoBloqueado.get(), buscarUsuarioPorPeriodoBloqueado(periodoBloqueado.get()));
        } else {
            throw new EntidadeNaoEncontradaException("Periodo não encontrado");
        }
    }

    //DELETE
    @Transactional
    public void deletarPeriodoBloqueado(UUID id) {
        periodoBloqueadoRepository.deleteById(id);
    }

    //METODOS AUXILIARES
    private PeriodoBloqueadoResponseDTO converterPeriodoBloqueadoParaResponseDTO(PeriodoBloqueadoModel periodoBloqueado, UsuarioModel usuario) {
        return new PeriodoBloqueadoResponseDTO(
                usuario.getEmail(),
                usuario.getNome(),
                periodoBloqueado.getRazaoBloqueio(),
                periodoBloqueado.getInicioPeriodoBloqueio(),
                periodoBloqueado.getFinalPeriodoBloqueio()
        );
    }

    private UsuarioModel buscarUsuarioPorPeriodoBloqueado(PeriodoBloqueadoModel periodoBloqueado) {

        Optional<UsuarioModel> usuario = usuarioRepository.findById(periodoBloqueado.getUsuarioResponsavel().getId());
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new EntidadeNaoEncontradaException("Usuário não encontrado");
        }
    }
}
