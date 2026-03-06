package com.gabrielli.hospital_api.util;

import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Data {

    private Data() {}

    public static LocalDate parseLocalDate(String data){
        return LocalDate.parse(data);
    }

    public static LocalDateTime inicioDia(LocalDate data){
        return data.atStartOfDay();
    }

    public static LocalDateTime fimDoDia(LocalDate data){
        return data.atTime(23,59,59);
    }

}
