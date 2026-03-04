package com.gabrielli.hospital_api.DTO;

import com.gabrielli.hospital_api.enums.StatusAgendamento;
import com.gabrielli.hospital_api.model.Medico;
import java.time.LocalDateTime;

public record AgendamentoUpdateDTO(Long medicoId, LocalDateTime dataHora, StatusAgendamento status) {

}
