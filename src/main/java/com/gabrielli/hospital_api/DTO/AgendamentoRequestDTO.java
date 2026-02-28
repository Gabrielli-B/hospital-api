package com.gabrielli.hospital_api.DTO;

import com.gabrielli.hospital_api.controller.enums.StatusAgendamento;
import com.gabrielli.hospital_api.model.Medico;
import com.gabrielli.hospital_api.model.Paciente;

import java.time.LocalTime;

public record AgendamentoRequestDTO(Medico medico, Paciente paciente, LocalTime dataHora, StatusAgendamento status) {

}
