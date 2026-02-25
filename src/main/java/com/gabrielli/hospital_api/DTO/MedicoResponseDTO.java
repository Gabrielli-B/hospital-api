package com.gabrielli.hospital_api.DTO;

import com.gabrielli.hospital_api.model.Medico;

public record MedicoResponseDTO (String nome, String cpf, int idade, Long id, String crm, String especialidade){
    public MedicoResponseDTO(Medico medico){
        this(medico.getNome(),medico.getCpf(), medico.getIdade(), medico.getId(), medico.getCrm(), medico.getEspecialidade());
    }
}
