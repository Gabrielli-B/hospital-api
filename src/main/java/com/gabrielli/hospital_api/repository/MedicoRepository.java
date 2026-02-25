package com.gabrielli.hospital_api.repository;

import com.gabrielli.hospital_api.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico,Long> {

}
