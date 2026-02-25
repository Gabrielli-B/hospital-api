package com.gabrielli.hospital_api.model;

import com.gabrielli.hospital_api.DTO.MedicoRequestDTO;
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

    public Medico(MedicoRequestDTO data) {
        super(data.nome(), data.cpf(), data.idade());
        this.crm=data.crm();
        this.especialidade= data.especialidade();
    }
}
