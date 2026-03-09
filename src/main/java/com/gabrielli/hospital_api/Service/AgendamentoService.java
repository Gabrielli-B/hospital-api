package com.gabrielli.hospital_api.Service;
import com.gabrielli.hospital_api.DTO.AgendamentoRequestDTO;
import com.gabrielli.hospital_api.DTO.AgendamentoResponseDTO;
import com.gabrielli.hospital_api.DTO.AgendamentoUpdateDTO;
import com.gabrielli.hospital_api.enums.StatusAgendamento;
import com.gabrielli.hospital_api.exception.DadoInvalidoException;
import com.gabrielli.hospital_api.exception.IdNotExistException;
import com.gabrielli.hospital_api.model.Agendamento;
import com.gabrielli.hospital_api.model.Medico;
import com.gabrielli.hospital_api.model.Paciente;
import com.gabrielli.hospital_api.repository.AgendamentoRepository;
import com.gabrielli.hospital_api.util.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final MedicoService medicoService;
    private final PacienteService pacienteService;

    public AgendamentoService(AgendamentoRepository agendamentoRepository,MedicoService medicoService, PacienteService pacienteService) {
        this.agendamentoRepository = agendamentoRepository;
        this.medicoService = medicoService;
        this.pacienteService = pacienteService;
    }

    //criar
    public AgendamentoResponseDTO criarAgendamento(AgendamentoRequestDTO agendamentoDto){
        Medico medico = medicoService.buscarMedicoPorId(agendamentoDto.medicoId());
        Paciente paciente = pacienteService.buscarPacienteId(agendamentoDto.pacienteId());

        Agendamento agendamento = new Agendamento(medico,paciente,agendamentoDto);

        verificarDataHora(agendamento);
        agendamentoRepository.save(agendamento);

        return new AgendamentoResponseDTO(agendamento);
    }

    //deletar agendamento
    public void deletarAgendamento(Long id){
        if(!agendamentoRepository.existsById(id)){
            throw new IdNotExistException(id);
        }
        agendamentoRepository.deleteById(id);
    }

    //atualizar agendamento
   public AgendamentoResponseDTO atualizarAgendamento(Long id, AgendamentoUpdateDTO agendamentoDto){
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(()->new IdNotExistException(id));
        if(agendamentoDto.medicoId()!=null){
            Medico medico = medicoService.buscarMedicoPorId(agendamentoDto.medicoId());
            agendamento.setMedico(medico);
        }
        if(agendamentoDto.dataHora()!=null){
            agendamento.setDataHora(agendamentoDto.dataHora());
            verificarDataHora(agendamento);
        }
        if(agendamentoDto.status()!=null){
            agendamento.setStatus(agendamentoDto.status());
        }
        agendamentoRepository.save(agendamento);
        return new AgendamentoResponseDTO(agendamento);
    }

    //buscar agendamentos pelo medico e dataHora
    public List<AgendamentoResponseDTO> buscarAgendamentoMedicoDataHora(Long medicoId, String data){
        Medico medico = medicoService.buscarMedicoPorId(medicoId);

        LocalDate localDate = Data.parseLocalDate(data);
        LocalDateTime inicio = Data.inicioDia(localDate);
        LocalDateTime fim = Data.fimDoDia(localDate);

        return agendamentoRepository.findByMedicoAndDataHoraBetween(medico,inicio,fim)
                .stream()
                .map(AgendamentoResponseDTO::new)
                .toList();
    }

    //buscar agendamentos pelo status
    public List<AgendamentoResponseDTO> buscarAgendamentoStatus(StatusAgendamento status){
        return agendamentoRepository.findByStatus(status)
                .stream()
                .map(AgendamentoResponseDTO::new)
                .toList();
    }

    public List<AgendamentoResponseDTO> buscarAgendamentoMedicoDataStatus(Long medicoId,StatusAgendamento status,String data){
        Medico medico = medicoService.buscarMedicoPorId(medicoId);
        LocalDate localDate = Data.parseLocalDate(data);
        LocalDateTime inicio = Data.inicioDia(localDate);
        LocalDateTime fim = Data.fimDoDia(localDate);

        return agendamentoRepository.findByMedicoAndStatusAndDataHoraBetween(medico,status,inicio,fim)
                .stream()
                .map(AgendamentoResponseDTO::new)
                .toList();
    }

   public List<AgendamentoResponseDTO> buscarAgendamentoData(String data){
       LocalDate localDate = Data.parseLocalDate(data);
       LocalDateTime inicio = Data.inicioDia(localDate);
       LocalDateTime fim = Data.fimDoDia(localDate);

       return agendamentoRepository.findByDataHoraBetween(inicio,fim)
               .stream()
               .map(AgendamentoResponseDTO::new)
               .toList();
    }

    public void verificarDataHora(Agendamento agendamento){
        if(agendamentoRepository.existsByMedicoAndDataHora(agendamento.getMedico(),agendamento.getDataHora())){
            throw new DadoInvalidoException("Horário já agendado");
        }
    }
}
