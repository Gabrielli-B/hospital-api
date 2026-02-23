package com.gabrielli.hospital_api.Service;

import com.gabrielli.hospital_api.DTO.PacienteRequestDTO;
import com.gabrielli.hospital_api.DTO.PacienteResponseDTO;
import com.gabrielli.hospital_api.exception.DadoInvalidoException;
import com.gabrielli.hospital_api.exception.PacienteNotExist;
import com.gabrielli.hospital_api.model.Paciente;
import com.gabrielli.hospital_api.repository.PacienteRepository;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository=pacienteRepository;
    }

    //criar
    public PacienteResponseDTO criarPaciente(PacienteRequestDTO data){
        Paciente paciente = new Paciente(data);
        Paciente pacienteSalvo = pacienteRepository.save(paciente);
        return new PacienteResponseDTO(pacienteSalvo);

    }
    //deletar
    public void deletarPaciente(long id){
        if(!pacienteRepository.existsById(id)){
            throw new PacienteNotExist(id);
        }
        pacienteRepository.deleteById(id);
    }

    //procurar paciente pelo id
    public PacienteResponseDTO buscarPaciente(long id){
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(()-> new PacienteNotExist(id));
        return new PacienteResponseDTO(paciente);
    }

    //atualizar dados paciente
    public PacienteResponseDTO atualizarDadosPaciente(long id, PacienteRequestDTO data) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(()-> new PacienteNotExist(id));
        if(data.telefone()!=null){
            if(data.telefone().isBlank()){
                throw new DadoInvalidoException("Telefone inválido");
            }
            paciente.setTelefone(data.telefone());
        }
        if(data.email()!=null){
            if(data.email().isBlank()){
                throw new DadoInvalidoException("Email inválido");
            }
            paciente.setEmail(data.email());
        }
        if(data.endereco()!=null){
            if(data.endereco().isBlank()){
                throw new DadoInvalidoException("Endereço inválido");
            }
            paciente.setEndereco(data.endereco());
        }
        pacienteRepository.save(paciente);
        return new PacienteResponseDTO(paciente);
    }
}
