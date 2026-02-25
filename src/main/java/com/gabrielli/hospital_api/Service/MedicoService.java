package com.gabrielli.hospital_api.Service;

import com.gabrielli.hospital_api.DTO.MedicoRequestDTO;
import com.gabrielli.hospital_api.DTO.MedicoResponseDTO;
import com.gabrielli.hospital_api.exception.IdNotExist;
import com.gabrielli.hospital_api.model.Medico;
import com.gabrielli.hospital_api.repository.MedicoRepository;
import com.gabrielli.hospital_api.repository.PacienteRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository){
        this.medicoRepository=medicoRepository;
    }


    //criar
    public MedicoResponseDTO criarMedico(MedicoRequestDTO data){
        Medico medico = new Medico(data);
        medicoRepository.save(medico);
        return new MedicoResponseDTO(medico);
    }
    //deletar
    public void deletarMedico(Long id){
        if(!medicoRepository.existsById(id)){
            throw new IdNotExist(id);
        }
        medicoRepository.deleteById(id);
    }

}
