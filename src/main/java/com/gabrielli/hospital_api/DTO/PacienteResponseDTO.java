package com.gabrielli.hospital_api.DTO;

import com.gabrielli.hospital_api.model.Paciente;

public record PacienteResponseDTO (long id, String nome, String cpf, int idade, String telefone, String email, String endereco){
    public PacienteResponseDTO(Paciente paciente){
        this(paciente.getId(),paciente.getNome(),paciente.getCpf(),paciente.getIdade(),paciente.getTelefone(),paciente.getEmail(),paciente.getEndereco());
    }
}
