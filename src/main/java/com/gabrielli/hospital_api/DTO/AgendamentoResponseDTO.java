package com.gabrielli.hospital_api.DTO;

import com.gabrielli.hospital_api.enums.StatusAgendamento;
import com.gabrielli.hospital_api.model.Agendamento;
import com.gabrielli.hospital_api.model.Medico;
import com.gabrielli.hospital_api.model.Paciente;

import java.time.LocalDateTime;
import java.time.LocalTime;
public record AgendamentoResponseDTO(Long id, MedicoResponseDTO medico, PacienteResponseDTO paciente, LocalDateTime dataHora, StatusAgendamento status) {
   public AgendamentoResponseDTO(Agendamento agendamento){
       this(
               agendamento.getId(),
               new MedicoResponseDTO(agendamento.getMedico()),
               new PacienteResponseDTO(agendamento.getPaciente()),
               agendamento.getDataHora(),
               agendamento.getStatus());
   }
}
