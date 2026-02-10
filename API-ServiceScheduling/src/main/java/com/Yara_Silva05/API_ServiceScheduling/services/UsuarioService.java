package com.Yara_Silva05.API_ServiceScheduling.services;

import com.Yara_Silva05.API_ServiceScheduling.dtos.requests.AtualizarUsuarioRequestDTO;
import com.Yara_Silva05.API_ServiceScheduling.dtos.requests.UsuarioRequestDTO;
import com.Yara_Silva05.API_ServiceScheduling.dtos.responses.UsuarioResponseDTO;
import com.Yara_Silva05.API_ServiceScheduling.exceptions.EmailExistenteException;
import com.Yara_Silva05.API_ServiceScheduling.exceptions.EntidadeNaoEncontradaException;
import com.Yara_Silva05.API_ServiceScheduling.models.UsuarioModel;
import com.Yara_Silva05.API_ServiceScheduling.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //POST
    @Transactional
    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO body){
        UsuarioModel usuario = new UsuarioModel(
                body.nome(),
                body.email(),
                body.senha(),
                body.cargo()
        );
        try {
            usuarioRepository.save(usuario);

            return converterUsuarioParaResponseDTO(usuario);

        } catch (DataIntegrityViolationException e){
            throw new EmailExistenteException();
        }
    }

    //GET ALL
    public List<UsuarioResponseDTO> buscarTodosUsuarios() {
         List<UsuarioModel> usuarios = usuarioRepository.findAll();
         List<UsuarioResponseDTO> dtos = new ArrayList<>();

         for (UsuarioModel usuario: usuarios) {
             dtos.add(converterUsuarioParaResponseDTO(usuario));
         }
         return dtos;
    }

    //GET BY ID
    public UsuarioResponseDTO buscarUsuarioPorID(UUID id){
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return converterUsuarioParaResponseDTO(usuario.get());
        } else {
            throw new EntidadeNaoEncontradaException("Usuário não encontrado");
        }
    }

    //PUT BY ID
    public UsuarioResponseDTO atualizarUsuario(UUID id, AtualizarUsuarioRequestDTO body){
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {

            usuario.get().setNome(body.nome());
            usuario.get().setEmail(body.email());

            usuarioRepository.save(usuario.get());

            return converterUsuarioParaResponseDTO(usuario.get());
        } else {
            throw new EntidadeNaoEncontradaException("Usuário não encontrado");
        }
    }

    //DELETE
    @Transactional
    public void deletarUsuario(UUID id) {
        usuarioRepository.deleteById(id);
    }

    //METODO AUXILIAR
    private UsuarioResponseDTO converterUsuarioParaResponseDTO(UsuarioModel usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getCargo().getCargoRelatorio()
        );
    }

}
