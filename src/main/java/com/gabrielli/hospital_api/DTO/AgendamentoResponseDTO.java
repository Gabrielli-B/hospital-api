package com.gabrielli.hospital_api.DTO;

import com.gabrielli.hospital_api.enums.StatusAgendamento;
import com.gabrielli.hospital_api.model.Agendamento;
import com.gabrielli.hospital_api.model.Medico;
import com.gabrielli.hospital_api.model.Paciente;

import java.time.LocalDateTime;
import java.time.LocalTime;
//proximo ajuste nos Dtos do agendamento para nao expor entidades!!!!!!!
public record AgendamentoResponseDTO(Long id, Medico medico, Paciente paciente, LocalDateTime dataHora, StatusAgendamento status) {
   public AgendamentoResponseDTO(Agendamento agendamento){
       this(agendamento.getId(),agendamento.getMedico(),agendamento.getPaciente(),agendamento.getDataHora(),agendamento.getStatus());
   }
}
