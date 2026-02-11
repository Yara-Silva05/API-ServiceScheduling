package com.Yara_Silva05.API_ServiceScheduling.models;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "TB_VAGA_BLOQUEADA")
public class PeriodoBloqueadoModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private LocalDateTime inicioPeriodoBloqueio;

    @Column(nullable = false)
    private LocalDateTime finalPeriodoBloqueio;

    @Column(nullable = false)
    private String razaoBloqueio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "usuario_responsavel",
            nullable = false
    )
    private UsuarioModel usuarioResponsavel;

    public PeriodoBloqueadoModel(LocalDateTime inicioPeriodoBloqueio, LocalDateTime finalPeriodoBloqueio, UsuarioModel usuarioResponsavel, String razaoBloqueio) {
        this.inicioPeriodoBloqueio = inicioPeriodoBloqueio;
        this.finalPeriodoBloqueio = finalPeriodoBloqueio;
        this.usuarioResponsavel = usuarioResponsavel;
        this.razaoBloqueio = razaoBloqueio.trim();
    }

    public PeriodoBloqueadoModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getInicioPeriodoBloqueio() {
        return inicioPeriodoBloqueio;
    }

    public void setInicioPeriodoBloqueio(LocalDateTime inicioPeriodoBloqueio) {
        this.inicioPeriodoBloqueio = inicioPeriodoBloqueio;
    }

    public LocalDateTime getFinalPeriodoBloqueio() {
        return finalPeriodoBloqueio;
    }

    public void setFinalPeriodoBloqueio(LocalDateTime finalPeriodoBloqueio) {
        this.finalPeriodoBloqueio = finalPeriodoBloqueio;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PeriodoBloqueadoModel that = (PeriodoBloqueadoModel) o;
        return Objects.equals(inicioPeriodoBloqueio, that.inicioPeriodoBloqueio) && Objects.equals(finalPeriodoBloqueio, that.finalPeriodoBloqueio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inicioPeriodoBloqueio, finalPeriodoBloqueio);
    }
}
