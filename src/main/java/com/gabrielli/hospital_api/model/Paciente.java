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

    public Paciente(PacienteRequestDTO data){
        super(data.nome(), data.cpf(), data.idade());
        this.telefone = data.telefone();
        this.email = data.email();
        this.endereco = data.endereco();
    }
}
