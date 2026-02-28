package com.gabrielli.hospital_api.enums;

import lombok.Getter;

@Getter
public enum StatusAgendamento {
    AGENDADO("Agendado"),
    CONFIRMADO("Confirmado"),
    CANCELADO("Cancelado");

    private String descricao;

    StatusAgendamento(String descricao) {
        this.descricao = descricao;
    }

}
