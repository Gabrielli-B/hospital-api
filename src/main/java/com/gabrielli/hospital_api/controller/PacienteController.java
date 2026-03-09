package com.gabrielli.hospital_api.controller;

import com.gabrielli.hospital_api.DTO.PacienteRequestDTO;
import com.gabrielli.hospital_api.DTO.PacienteResponseDTO;
import com.gabrielli.hospital_api.DTO.PacienteUpdateDTO;
import com.gabrielli.hospital_api.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @Operation(summary = "Cadastrar paciente")
    @PostMapping
    public PacienteResponseDTO criarPaciente(@RequestBody PacienteRequestDTO pacienteDto){return pacienteService.criarPaciente(pacienteDto);}

    @Operation(summary = "Buscar paciente pelo id")
    @GetMapping("/{id}")
    public PacienteResponseDTO buscarPaciente(@PathVariable long id){return pacienteService.buscarPaciente(id);};

    @Operation(summary = "Atualizar dados paciente pelo id")
    @PatchMapping("/{id}")
    public PacienteResponseDTO atualizarDadosPaciente(@PathVariable long id, @RequestBody PacienteUpdateDTO pacienteDto){return pacienteService.atualizarDadosPaciente(id,pacienteDto);}

    @Operation(summary = "Deletar paciente pelo id")
    @DeleteMapping("/{id}")
    public void deletarPaciente(@PathVariable long id){pacienteService.deletarPaciente(id);};

    @Operation(summary = "Listar pacientes")
    @GetMapping
    public List<PacienteResponseDTO> listarPacientes(){return pacienteService.listarPacientes();}
}
