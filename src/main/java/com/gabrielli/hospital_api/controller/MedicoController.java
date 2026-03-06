package com.gabrielli.hospital_api.controller;

import com.gabrielli.hospital_api.DTO.MedicoRequestDTO;
import com.gabrielli.hospital_api.DTO.MedicoResponseDTO;
import com.gabrielli.hospital_api.Service.MedicoService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/medicos")

public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService){
        this.medicoService=medicoService;
    }

    @PostMapping
    public MedicoResponseDTO criarMedico(@RequestBody MedicoRequestDTO medicoDto){return medicoService.criarMedico(medicoDto);}

    @DeleteMapping({"/{id}"})
    public void deletarMedico(@PathVariable Long id){medicoService.deletarMedico(id);}

    @GetMapping({"/{id}"})
    public MedicoResponseDTO buscarMedico(@PathVariable Long id){return medicoService.buscarMedico(id);}
}
