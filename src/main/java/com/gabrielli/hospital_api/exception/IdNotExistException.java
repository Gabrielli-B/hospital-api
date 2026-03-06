package com.gabrielli.hospital_api.exception;

public class IdNotExistException extends RuntimeException {
    public IdNotExistException(long id) {
        super(id + " não existe");
    }
}
