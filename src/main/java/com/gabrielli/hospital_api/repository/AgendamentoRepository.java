package com.gabrielli.hospital_api.repository;

import com.gabrielli.hospital_api.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
}
