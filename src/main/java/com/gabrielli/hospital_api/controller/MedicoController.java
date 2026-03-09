package com.gabrielli.hospital_api.controller;

import com.gabrielli.hospital_api.DTO.MedicoRequestDTO;
import com.gabrielli.hospital_api.DTO.MedicoResponseDTO;
import com.gabrielli.hospital_api.service.MedicoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/medicos")

public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService){
        this.medicoService=medicoService;
    }

    @Operation(summary = "Cadastrar medico")
    @PostMapping
    public MedicoResponseDTO criarMedico(@RequestBody MedicoRequestDTO medicoDto){return medicoService.criarMedico(medicoDto);}

    @Operation(summary = "Deletar medico pelo id")
    @DeleteMapping({"/{id}"})
    public void deletarMedico(@PathVariable Long id){medicoService.deletarMedico(id);}

    @Operation(summary = "Buscar medico pelo id")
    @GetMapping({"/{id}"})
    public MedicoResponseDTO buscarMedico(@PathVariable Long id){return medicoService.buscarMedico(id);}

    @Operation(summary = "Listar medicos")
    @GetMapping
    public List<MedicoResponseDTO> listarMedicos(){return medicoService.listarMedicos();}

}
