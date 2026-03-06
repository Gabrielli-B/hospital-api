package com.gabrielli.hospital_api.Service;
import com.gabrielli.hospital_api.DTO.MedicoRequestDTO;
import com.gabrielli.hospital_api.DTO.MedicoResponseDTO;
import com.gabrielli.hospital_api.exception.IdNotExistException;
import com.gabrielli.hospital_api.model.Medico;
import com.gabrielli.hospital_api.repository.MedicoRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository){
        this.medicoRepository=medicoRepository;
    }
    //criar
    public MedicoResponseDTO criarMedico(MedicoRequestDTO medicoDto){
        Medico medico = new Medico(medicoDto);
        medicoRepository.save(medico);
        return new MedicoResponseDTO(medico);
    }
    //deletar
    public void deletarMedico(Long id){
        if(!medicoRepository.existsById(id)){
            throw new IdNotExistException(id);
        }
        medicoRepository.deleteById(id);
    }
    //buscar
    public MedicoResponseDTO buscarMedico(Long id){
        Medico medico = medicoRepository.findById(id).orElseThrow(()->new IdNotExistException(id));
        return new MedicoResponseDTO(medico);
    }
}
