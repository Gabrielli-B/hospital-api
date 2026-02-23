package com.gabrielli.hospital_api.exception;

public class PacienteNotExist extends RuntimeException {
    public PacienteNotExist(long id) {
        super("Paciente com id " +id + " não existe");
    }
}
