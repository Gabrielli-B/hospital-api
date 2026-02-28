package com.gabrielli.hospital_api.repository;

import com.gabrielli.hospital_api.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {

boolean existsByDataHora(LocalDateTime dataHora);

}
