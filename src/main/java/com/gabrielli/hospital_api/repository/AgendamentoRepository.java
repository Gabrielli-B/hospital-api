package com.gabrielli.hospital_api.repository;
import com.gabrielli.hospital_api.enums.StatusAgendamento;
import com.gabrielli.hospital_api.model.Agendamento;
import com.gabrielli.hospital_api.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {

boolean existsByDataHora(LocalDateTime dataHora);
List<Agendamento> findByMedicoAndDataHoraBetween(Medico medico,LocalDateTime inicioDia,LocalDateTime fimDia);
List<Agendamento> findByStatus(StatusAgendamento status);
List<Agendamento> findByMedicoAndStatusAndDataHoraBetween(Medico medico,StatusAgendamento status,LocalDateTime inicioDia,LocalDateTime fimDia);



}
