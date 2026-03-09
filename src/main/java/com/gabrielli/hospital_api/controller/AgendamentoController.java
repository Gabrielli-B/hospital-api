package com.gabrielli.hospital_api.controller;
import com.gabrielli.hospital_api.DTO.AgendamentoRequestDTO;
import com.gabrielli.hospital_api.DTO.AgendamentoResponseDTO;
import com.gabrielli.hospital_api.DTO.AgendamentoUpdateDTO;
import com.gabrielli.hospital_api.service.AgendamentoService;
import com.gabrielli.hospital_api.enums.StatusAgendamento;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Criar agendamento")
    @PostMapping
    public AgendamentoResponseDTO criarAgendamento(@RequestBody AgendamentoRequestDTO agendamentoDto){return agendamentoService.criarAgendamento(agendamentoDto);}

    @Operation(summary = "Deletar agendamento pelo id")
    @DeleteMapping("/{id}")
    public void deletarAgendamento(@PathVariable Long id){agendamentoService.deletarAgendamento(id);}

    @Operation(summary = "Atualizar agendamento pelo id")
    @PatchMapping("/{id}")
    public AgendamentoResponseDTO atualizarAgendamento(@PathVariable Long id,@RequestBody AgendamentoUpdateDTO agendamentoDto){return agendamentoService.atualizarAgendamento(id,agendamentoDto);}

    @Operation(summary = "buscar agendamento pelo medico e data")
    @GetMapping("/medico/data")
    public List<AgendamentoResponseDTO> buscarAgendamentoMedicoEData(@RequestParam Long medicoId, @RequestParam String data){return agendamentoService.buscarAgendamentoMedicoDataHora(medicoId,data);}

    @Operation(summary = "Buscar agendamento pelo status")
    @GetMapping("/status")
    public List<AgendamentoResponseDTO> buscarAgendamentoStatus(@RequestParam StatusAgendamento status){return agendamentoService.buscarAgendamentoStatus(status);}

    @Operation(summary = "Buscar agendamento pelo medico, data e status")
    @GetMapping("/medico/data-status")
    public List<AgendamentoResponseDTO> buscarAgendamentoMedicoDataStatus(@RequestParam Long medicoId,@RequestParam StatusAgendamento status,@RequestParam String data){return agendamentoService.buscarAgendamentoMedicoDataStatus(medicoId,status,data);}

    @Operation(summary = "Buscar agendaemnto pela data")
    @GetMapping("/data")
    public List<AgendamentoResponseDTO> buscarAgendamentoData(@RequestParam String data){return agendamentoService.buscarAgendamentoData(data);}
}
