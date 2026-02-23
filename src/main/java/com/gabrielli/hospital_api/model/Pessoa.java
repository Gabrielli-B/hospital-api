package com.gabrielli.hospital_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Pessoa {
    private String nome;

    @Column(unique = true,nullable = false)
    private String cpf;

    private int idade;

    public Pessoa(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }
}
