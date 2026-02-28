package com.gabrielli.hospital_api.DTO;

import com.gabrielli.hospital_api.controller.enums.StatusAgendamento;
import com.gabrielli.hospital_api.model.Agendamento;
import com.gabrielli.hospital_api.model.Medico;
import com.gabrielli.hospital_api.model.Paciente;

import java.time.LocalTime;

public record AgendamentoResponseDTO(Long id,Medico medico, Paciente paciente, LocalTime dataHora, StatusAgendamento status) {
   public AgendamentoResponseDTO(Agendamento agendamento){
       this(agendamento.getId(),agendamento.getMedico(),agendamento.getPaciente(),agendamento.getDataHora(),agendamento.getStatus());
   }
}
