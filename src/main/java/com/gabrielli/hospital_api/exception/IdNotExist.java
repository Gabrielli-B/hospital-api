package com.gabrielli.hospital_api.exception;

public class IdNotExist extends RuntimeException {
    public IdNotExist(long id) {
        super(id + " não existe");
    }
}
