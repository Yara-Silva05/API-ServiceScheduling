package com.Yara_Silva05.API_ServiceScheduling.services;

import com.Yara_Silva05.API_ServiceScheduling.dtos.requests.AgendamentoRequestDTO;
import com.Yara_Silva05.API_ServiceScheduling.dtos.requests.AtualizarAgendamentoRequestDTO;
import com.Yara_Silva05.API_ServiceScheduling.dtos.responses.AgendamentoResponseDTO;
import com.Yara_Silva05.API_ServiceScheduling.exceptions.EntidadeNaoEncontradaException;
import com.Yara_Silva05.API_ServiceScheduling.exceptions.PeriodoNaoDisponivelException;
import com.Yara_Silva05.API_ServiceScheduling.models.AgendamentoModel;
import com.Yara_Silva05.API_ServiceScheduling.models.UsuarioModel;
import com.Yara_Silva05.API_ServiceScheduling.repositories.AgendamentoRepository;
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
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PeriodoBloqueadoRepository periodoBloqueadoRepository;

    //POST
    @Transactional
    public AgendamentoResponseDTO criarAgendamento(AgendamentoRequestDTO body){

        if (periodoBloqueadoRepository.existePeriodoBloqueadoConflitante(body.inicioAgendamento(),body.encerramentoAgendamento())) {
            throw new PeriodoNaoDisponivelException();
        }

        Optional<UsuarioModel> usuario = usuarioRepository.findById(body.idUsuario());
        if (usuario.isPresent()) {
            AgendamentoModel agendamento = new AgendamentoModel(
                    usuario.get(),
                    body.descricao(),
                    body.inicioAgendamento(),
                    body.encerramentoAgendamento()
            );

            usuario.get().adicionarAgendamento(agendamento);
            usuarioRepository.save(usuario.get());

            return new AgendamentoResponseDTO(
                    agendamento.getId(),
                    usuario.get().getEmail(),
                    usuario.get().getNome(),
                    agendamento.getDescricao(),
                    agendamento.getInicio(),
                    agendamento.getEncerramento()
            );
        }else {
            throw new EntidadeNaoEncontradaException("Usuário não encontrado");
        }
    }

    //GET ALL
    public List<AgendamentoResponseDTO> buscarTodosAgendamentos() {

        List<AgendamentoModel> agendamentos = agendamentoRepository.findAll();

        List<AgendamentoResponseDTO> dtos = new ArrayList<>();

        for (AgendamentoModel agendamento: agendamentos) {
            dtos.add(converterAgendamentoParaResponseDTO(agendamento,buscarUsuarioPorAgendamento(agendamento)));
        }
        return dtos;
    }

    //GET BY ID
    public AgendamentoResponseDTO buscarAgendamentoPorID(UUID id){

        Optional<AgendamentoModel> agendamento = agendamentoRepository.findById(id);

        if (agendamento.isPresent()) {
            return converterAgendamentoParaResponseDTO(agendamento.get(), buscarUsuarioPorAgendamento(agendamento.get()));
        } else {
            throw new EntidadeNaoEncontradaException("Agendamento não encontrado");
        }
    }

    //PUT BY ID
    public AgendamentoResponseDTO atualizarAgendamento(UUID id, AtualizarAgendamentoRequestDTO body){

        if (periodoBloqueadoRepository.existePeriodoBloqueadoConflitante(body.inicioAgendamento(),body.encerramentoAgendamento())) {
            throw new PeriodoNaoDisponivelException();
        }

        Optional<AgendamentoModel> agendamento = agendamentoRepository.findById(id);

        if (agendamento.isPresent()) {

            agendamento.get().setInicio(body.inicioAgendamento());
            agendamento.get().setEncerramento(body.encerramentoAgendamento());
            agendamento.get().setDescricao(body.descricao());

            agendamentoRepository.save(agendamento.get());

            return converterAgendamentoParaResponseDTO(agendamento.get(), buscarUsuarioPorAgendamento(agendamento.get()));
        } else {
            throw new EntidadeNaoEncontradaException("Agendamento não encontrado");
        }
    }

    //DELETE
    @Transactional
    public void deletarAgendamento(UUID id) {
        agendamentoRepository.deleteById(id);
    }

    //METODOS AUXILIARES
    private UsuarioModel buscarUsuarioPorAgendamento (AgendamentoModel agendamento) {

        Optional<UsuarioModel> usuario = usuarioRepository.findById(agendamento.getUsuario().getId());
        if (usuario.isPresent()) {
            return usuario.get();
        }
        else {
            throw new EntidadeNaoEncontradaException("Usuário não encontrado");
        }
    }

    private AgendamentoResponseDTO converterAgendamentoParaResponseDTO(AgendamentoModel agendamento, UsuarioModel usuario) {
        return new AgendamentoResponseDTO(
                agendamento.getId(),
                usuario.getEmail(),
                usuario.getNome(),
                agendamento.getDescricao(),
                agendamento.getInicio(),
                agendamento.getEncerramento()
        );
    }
}
