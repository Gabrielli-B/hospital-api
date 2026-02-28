package com.gabrielli.hospital_api.util;

import com.gabrielli.hospital_api.DTO.AgendamentoUpdateDTO;
import com.gabrielli.hospital_api.enums.StatusAgendamento;
import com.gabrielli.hospital_api.exception.DadoInvalidoException;
import com.gabrielli.hospital_api.model.Agendamento;
import com.gabrielli.hospital_api.model.Medico;

import java.time.LocalDateTime;

public class ValidarCampos {

    public static void validarCampoPaciente(String valor, String nomeCampo){
        if(valor.isBlank()){
            throw new DadoInvalidoException(nomeCampo + " inválido");
        }
    }
}
