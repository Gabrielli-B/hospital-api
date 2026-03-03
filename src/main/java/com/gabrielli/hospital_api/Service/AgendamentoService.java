package com.gabrielli.hospital_api.Service;
import com.gabrielli.hospital_api.DTO.AgendamentoRequestDTO;
import com.gabrielli.hospital_api.DTO.AgendamentoResponseDTO;
import com.gabrielli.hospital_api.DTO.AgendamentoUpdateDTO;
import com.gabrielli.hospital_api.enums.StatusAgendamento;
import com.gabrielli.hospital_api.exception.IdNotExist;
import com.gabrielli.hospital_api.model.Agendamento;
import com.gabrielli.hospital_api.model.Medico;
import com.gabrielli.hospital_api.repository.AgendamentoRepository;
import com.gabrielli.hospital_api.repository.MedicoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final MedicoRepository medicoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository,MedicoRepository medicoRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.medicoRepository = medicoRepository;
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
        if(agendamentoDto.medico()!=null){
            agendamento.setMedico(agendamentoDto.medico());
        }
        if(agendamentoDto.dataHora()!=null){
            verificarDataHora(agendamento);
            agendamento.setDataHora(agendamentoDto.dataHora());
        }
        if(agendamentoDto.status()!=null){
            agendamento.setStatus(agendamentoDto.status());
        }
        agendamentoRepository.save(agendamento);
        return new AgendamentoResponseDTO(agendamento);
    }

    //buscar agendamentos pelo medico e dataHora
    public List<Agendamento> buscarAgendamentoMedicoDataHora(Long medicoId, LocalDateTime inicioDia, LocalDateTime fimDia){
        Medico medico = medicoRepository.findById(medicoId).orElseThrow(() -> new IdNotExist(medicoId));
        return agendamentoRepository.findByMedicoAndDataHoraBetween(medico,inicioDia,fimDia);
    }

    //buscar agendamentos pelo status
    public List<Agendamento> buscarAgendamentoStatus(StatusAgendamento status){
        return agendamentoRepository.findByStatus(status);
    }

    public List<Agendamento> buscarAgendamentoMedicoDataStatus(Long medicoId,StatusAgendamento status,LocalDateTime inicioDia,LocalDateTime fimDia){
        Medico medico = medicoRepository.findById(medicoId).orElseThrow(() -> new IdNotExist(medicoId));
        return agendamentoRepository.findByMedicoAndStatusAndDataHoraBetween(medico,status,inicioDia,fimDia);
    }

    public void verificarDataHora(Agendamento agendamento){
        if(agendamentoRepository.existsByDataHora(agendamento.getDataHora())){
            throw new RuntimeException("Impossível agendar! horário já agendado");
        }
    }
}
