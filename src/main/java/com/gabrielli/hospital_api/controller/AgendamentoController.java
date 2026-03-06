package com.gabrielli.hospital_api.controller;
import com.gabrielli.hospital_api.DTO.AgendamentoRequestDTO;
import com.gabrielli.hospital_api.DTO.AgendamentoResponseDTO;
import com.gabrielli.hospital_api.DTO.AgendamentoUpdateDTO;
import com.gabrielli.hospital_api.Service.AgendamentoService;
import com.gabrielli.hospital_api.enums.StatusAgendamento;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/agendamentos")

public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public AgendamentoResponseDTO criarAgendamento(@RequestBody AgendamentoRequestDTO agendamentoDto){return agendamentoService.criarAgendamento(agendamentoDto);}

    @DeleteMapping("/{id}")
    public void deletarAgendamento(@PathVariable Long id){agendamentoService.deletarAgendamento(id);}

    @PatchMapping("/{id}")
    public AgendamentoResponseDTO atualizarAgendamento(@PathVariable Long id,@RequestBody AgendamentoUpdateDTO agendamentoDto){return agendamentoService.atualizarAgendamento(id,agendamentoDto);}

    @GetMapping("/medico/data")
    public List<AgendamentoResponseDTO> buscarAgendamentoMedicoEData(@RequestParam Long medicoId, @RequestParam String data){return agendamentoService.buscarAgendamentoMedicoDataHora(medicoId,data);}

    @GetMapping("/status")
    public List<AgendamentoResponseDTO> buscarAgendamentoStatus(@RequestParam StatusAgendamento status){return agendamentoService.buscarAgendamentoStatus(status);}

    @GetMapping("/medico/data-status")
    public List<AgendamentoResponseDTO> buscarAgendamentoMedicoDataStatus(@RequestParam Long medicoId,@RequestParam StatusAgendamento status,@RequestParam String data){return agendamentoService.buscarAgendamentoMedicoDataStatus(medicoId,status,data);}

    @GetMapping("/data")
    public List<AgendamentoResponseDTO> buscarAgendamentoData(@RequestParam String data){return agendamentoService.buscarAgendamentoData(data);}
}
