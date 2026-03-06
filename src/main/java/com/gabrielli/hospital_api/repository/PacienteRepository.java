package com.gabrielli.hospital_api.repository;

import com.gabrielli.hospital_api.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {

}
