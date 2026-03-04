package com.gabrielli.hospital_api.DTO;

import com.gabrielli.hospital_api.enums.StatusAgendamento;
import com.gabrielli.hospital_api.model.Medico;
import com.gabrielli.hospital_api.model.Paciente;

import java.time.LocalDateTime;
import java.time.LocalTime;


public record AgendamentoRequestDTO(Long medicoId, Long pacienteId, LocalDateTime dataHora, StatusAgendamento status) {

}
