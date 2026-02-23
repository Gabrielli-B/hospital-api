package com.gabrielli.hospital_api.controller;

import com.gabrielli.hospital_api.DTO.PacienteRequestDTO;
import com.gabrielli.hospital_api.DTO.PacienteResponseDTO;
import com.gabrielli.hospital_api.Service.PacienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital-api")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping
    public PacienteResponseDTO criarPaciente(@RequestBody PacienteRequestDTO data){return pacienteService.criarPaciente(data);}

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/{id}")
    public PacienteResponseDTO buscarPaciente(@PathVariable long id){return pacienteService.buscarPaciente(id);};

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deletarPaciente(@PathVariable long id){pacienteService.deletarPaciente(id);};
}
