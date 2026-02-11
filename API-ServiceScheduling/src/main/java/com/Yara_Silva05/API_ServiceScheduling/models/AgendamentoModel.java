package com.Yara_Silva05.API_ServiceScheduling.models;

import com.Yara_Silva05.API_ServiceScheduling.exceptions.DataInvalidaException;
import com.Yara_Silva05.API_ServiceScheduling.models.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "TB_AGENDAMENTOS")
public class AgendamentoModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private StatusEnum status = StatusEnum.AGENDADO;

    @Column(nullable = false)
    private LocalDateTime inicio;

    @Column(nullable = false)
    private LocalDateTime encerramento;

    @Column(nullable = false)
    private final LocalDateTime dataCriacao = LocalDateTime.now();

    public AgendamentoModel(String descricao, LocalDateTime inicio, LocalDateTime encerramento) {
        if (inicio.isBefore(encerramento)) {
            this.descricao = descricao;
            this.inicio = inicio;
            this.encerramento = encerramento;
        }else {
            throw new DataInvalidaException();
        }
    }

    public UUID getId() {
        return id;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getEncerramento() {
        return encerramento;
    }

    public void setEncerramento(LocalDateTime encerramento) {
        this.encerramento = encerramento;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
