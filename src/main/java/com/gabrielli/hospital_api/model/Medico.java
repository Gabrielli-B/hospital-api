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

    public Medico(MedicoRequestDTO medicoDto) {
        super(medicoDto.nome(), medicoDto.cpf(), medicoDto.idade());
        this.crm=medicoDto.crm();
        this.especialidade= medicoDto.especialidade();
    }
}
