package com.feliperodsdev.fifastats.model.exceptions;

public class EntityValidationException extends RuntimeException {
    public EntityValidationException(String msg){
        super(msg);
    }
}
