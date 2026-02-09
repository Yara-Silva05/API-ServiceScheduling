package com.Yara_Silva05.API_ServiceScheduling.models;

import com.Yara_Silva05.API_ServiceScheduling.models.enums.CargoEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_USUARIO")
public class UsuarioModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private CargoEnum cargo;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<AgendamentoModel> agendamentos = new HashSet<>();

    public UsuarioModel(String nome, String email, String senha, String cargo) {
        this.nome = nome.trim();
        this.email = email.trim();
        this.senha = senha.trim();
        this.cargo = CargoEnum.valueOf(cargo.toUpperCase().trim());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public CargoEnum getCargo() {
        return cargo;
    }

    public void setCargo(CargoEnum cargo) {
        this.cargo = cargo;
    }

    public Set<AgendamentoModel> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(Set<AgendamentoModel> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
