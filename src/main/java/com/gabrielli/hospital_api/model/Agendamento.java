package com.gabrielli.hospital_api.model;

import com.gabrielli.hospital_api.DTO.AgendamentoRequestDTO;
import com.gabrielli.hospital_api.controller.enums.StatusAgendamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalTime;


@Entity
@Table (name = "agendamentos")
@NoArgsConstructor
@Getter

public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Medico medico;
    private Paciente paciente;
    private LocalTime dataHora;
    private StatusAgendamento status;

    public Agendamento(AgendamentoRequestDTO agendamentoDto) {
        this.medico = agendamentoDto.medico();
        this.paciente = agendamentoDto.paciente();
        this.dataHora = agendamentoDto.dataHora();;
        this.status = agendamentoDto.status();
    }
}
