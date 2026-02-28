package com.gabrielli.hospital_api.Service;

import com.gabrielli.hospital_api.DTO.PacienteRequestDTO;
import com.gabrielli.hospital_api.DTO.PacienteResponseDTO;
import com.gabrielli.hospital_api.DTO.PacienteUpdateDTO;
import com.gabrielli.hospital_api.exception.IdNotExist;
import com.gabrielli.hospital_api.model.Paciente;
import com.gabrielli.hospital_api.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import static com.gabrielli.hospital_api.util.ValidarCampos.validarCampoPaciente;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository=pacienteRepository;
    }

    //criar
    public PacienteResponseDTO criarPaciente(PacienteRequestDTO pacienteDto){
        Paciente paciente = new Paciente(pacienteDto);
        Paciente pacienteSalvo = pacienteRepository.save(paciente);
        return new PacienteResponseDTO(pacienteSalvo);

    }
    //deletar
    public void deletarPaciente(long id){
        if(!pacienteRepository.existsById(id)){
            throw new IdNotExist(id);
        }
        pacienteRepository.deleteById(id);
    }

    //procurar paciente pelo id
    public PacienteResponseDTO buscarPaciente(long id){
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(()-> new IdNotExist(id));
        return new PacienteResponseDTO(paciente);
    }

    //atualizar dados paciente
    public PacienteResponseDTO atualizarDadosPaciente(long id, PacienteUpdateDTO pacienteDto) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(()-> new IdNotExist(id));
        if(pacienteDto.endereco()!=null){
            validarCampoPaciente(pacienteDto.endereco(), " endereço");
            paciente.setEndereco(pacienteDto.endereco());
        }
        if(pacienteDto.email()!=null){
            validarCampoPaciente(pacienteDto.email()," E-mail");
            paciente.setEmail(pacienteDto.email());
        }
        if(pacienteDto.telefone()!=null){
            validarCampoPaciente(pacienteDto.telefone()," telefone");
            paciente.setTelefone(pacienteDto.telefone());
        }
        pacienteRepository.save(paciente);
        return  new PacienteResponseDTO(paciente);
    }
}
