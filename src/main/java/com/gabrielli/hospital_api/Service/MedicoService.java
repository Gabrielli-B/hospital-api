package com.gabrielli.hospital_api.Service;

import com.gabrielli.hospital_api.repository.MedicoRepository;
import com.gabrielli.hospital_api.repository.PacienteRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository){
        this.medicoRepository=medicoRepository;
    }


}
