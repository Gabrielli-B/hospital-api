package com.gabrielli.hospital_api.util;

import com.gabrielli.hospital_api.exception.DadoInvalidoException;

public class ValidarCampos {

    public static void validarCampo(String valor, String nomeCampo){
        if(valor.isBlank()){
            throw new DadoInvalidoException(nomeCampo + " inválido");
        }
    }
}
