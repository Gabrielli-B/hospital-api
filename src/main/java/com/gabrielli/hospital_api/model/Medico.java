package com.gabrielli.hospital_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "medicos")
@Entity
@Getter
@Setter
@NoArgsConstructor

public class Medico  extends Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String crm;
    private String especialidade;

    public Medico(String nome, String cpf, int idade, Long id, String crm, String especialidade) {
        super(nome, cpf, idade);
        this.id = id;
        this.crm = crm;
        this.especialidade = especialidade;
    }
}
