package com.gabrielli.hospital_api.Service;

import com.gabrielli.hospital_api.DTO.AgendamentoRequestDTO;
import com.gabrielli.hospital_api.DTO.AgendamentoResponseDTO;
import com.gabrielli.hospital_api.DTO.AgendamentoUpdateDTO;
import com.gabrielli.hospital_api.exception.IdNotExist;
import com.gabrielli.hospital_api.model.Agendamento;
import com.gabrielli.hospital_api.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    //criar
    public AgendamentoResponseDTO criarAgendamento(AgendamentoRequestDTO agendamentoDto){
        Agendamento agendamento = new Agendamento(agendamentoDto);
        verificarDataHora(agendamento);
        agendamentoRepository.save(agendamento);
        return new AgendamentoResponseDTO(agendamento);
    }

    //deletar agendamento
    public void deletarAgendamento(Long id){
        if(!agendamentoRepository.existsById(id)){
            throw new IdNotExist(id);
        }
        agendamentoRepository.deleteById(id);
    }

    //atualizar agendamento
   public AgendamentoResponseDTO atualizarAgendamento(Long id, AgendamentoUpdateDTO agendamentoDto){
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(()->new IdNotExist(id));
        verificarDataHora(agendamento);
        if(agendamento.getMedico()!=null){
            agendamento.setMedico(agendamentoDto.medico());
        }
        if(agendamento.getDataHora()!=null){
            agendamento.setDataHora(agendamentoDto.dataHora());
        }
        if(agendamento.getStatus()!=null){
            agendamento.setStatus(agendamentoDto.status());
        }
        return new AgendamentoResponseDTO(agendamento);
    }

    public void verificarDataHora(Agendamento agendamento){
        if(agendamentoRepository.existsByDataHora(agendamento.getDataHora())){
            throw new RuntimeException("Impossível agendar! horário já agendado");
        }
    }
}
