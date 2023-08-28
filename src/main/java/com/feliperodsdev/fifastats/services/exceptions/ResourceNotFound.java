package com.feliperodsdev.fifastats.services.exceptions;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String msg){
        super(msg);
    }

}