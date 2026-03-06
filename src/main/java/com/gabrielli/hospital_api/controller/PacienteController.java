package com.gabrielli.hospital_api.controller;

import com.gabrielli.hospital_api.DTO.PacienteRequestDTO;
import com.gabrielli.hospital_api.DTO.PacienteResponseDTO;
import com.gabrielli.hospital_api.DTO.PacienteUpdateDTO;
import com.gabrielli.hospital_api.Service.PacienteService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public PacienteResponseDTO criarPaciente(@RequestBody PacienteRequestDTO pacienteDto){return pacienteService.criarPaciente(pacienteDto);}

    @GetMapping("/{id}")
    public PacienteResponseDTO buscarPaciente(@PathVariable long id){return pacienteService.buscarPaciente(id);};

    @PatchMapping("/{id}")
    public PacienteResponseDTO atualizarDadosPaciente(@PathVariable long id, @RequestBody PacienteUpdateDTO pacienteDto){return pacienteService.atualizarDadosPaciente(id,pacienteDto);}

    @DeleteMapping("/{id}")
    public void deletarPaciente(@PathVariable long id){pacienteService.deletarPaciente(id);};
}
