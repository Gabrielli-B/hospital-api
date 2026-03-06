package com.gabrielli.hospital_api.model;

import com.gabrielli.hospital_api.DTO.AgendamentoRequestDTO;
import com.gabrielli.hospital_api.enums.StatusAgendamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table (name = "agendamentos")
@NoArgsConstructor
@Getter
@Setter


public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne //relacionamento muitos para 1, chave estrangeira
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime dataHora;
    private StatusAgendamento status;

    public Agendamento(Medico medico, Paciente paciente, AgendamentoRequestDTO agendamentoDto) {
        this.medico = medico;
        this.paciente = paciente;
        this.dataHora = agendamentoDto.dataHora();;
        this.status = agendamentoDto.status();
    }
}
