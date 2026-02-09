package com.Yara_Silva05.API_ServiceScheduling.services;

import com.Yara_Silva05.API_ServiceScheduling.dtos.UsuarioRequestDTO;
import com.Yara_Silva05.API_ServiceScheduling.dtos.UsuarioResponseDTO;
import com.Yara_Silva05.API_ServiceScheduling.exceptions.EmailExistenteException;
import com.Yara_Silva05.API_ServiceScheduling.models.UsuarioModel;
import com.Yara_Silva05.API_ServiceScheduling.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

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

            return new UsuarioResponseDTO(
                    usuario.getId(),
                    usuario.getNome(),
                    usuario.getEmail(),
                    usuario.getCargo().getCargoRelatorio()
            );
        } catch (Exception e){
            throw new EmailExistenteException();
        }
    }
}
