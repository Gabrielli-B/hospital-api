package com.gabrielli.hospital_api.model;

import com.gabrielli.hospital_api.DTO.PacienteRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "pacientes")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Paciente extends Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String telefone;
    private String email;
    private String endereco;

    public Paciente(PacienteRequestDTO pacienteDto){
        super(pacienteDto.nome(), pacienteDto.cpf(), pacienteDto.idade());
        this.telefone = pacienteDto.telefone();
        this.email = pacienteDto.email();
        this.endereco = pacienteDto.endereco();
    }
}
