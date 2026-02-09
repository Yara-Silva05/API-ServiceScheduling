package com.Yara_Silva05.API_ServiceScheduling.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_VAGA_BLOQUEADA")
public class HorarioBloqueadoModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private LocalDateTime inicioBloqueio;

    @Column(nullable = false)
    private LocalDateTime finalBloqueio;

    @Column(nullable = false)
    private String razaoBloqueio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "usuario_responsavel",
            nullable = false
    )
    private UsuarioModel usuarioResponsavel;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getInicioBloqueio() {
        return inicioBloqueio;
    }

    public void setInicioBloqueio(LocalDateTime inicioBloqueio) {
        this.inicioBloqueio = inicioBloqueio;
    }

    public LocalDateTime getFinalBloqueio() {
        return finalBloqueio;
    }

    public void setFinalBloqueio(LocalDateTime finalBloqueio) {
        this.finalBloqueio = finalBloqueio;
    }

    public String getRazaoBloqueio() {
        return razaoBloqueio;
    }

    public void setRazaoBloqueio(String razaoBloqueio) {
        this.razaoBloqueio = razaoBloqueio;
    }

    public UsuarioModel getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public void setUsuarioResponsavel(UsuarioModel usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;
    }


}
