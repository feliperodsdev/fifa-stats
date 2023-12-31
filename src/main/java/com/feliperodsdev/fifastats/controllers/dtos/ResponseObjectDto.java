package com.feliperodsdev.fifastats.controllers.dtos;

public class ResponseObjectDto <T> {

    private T data;
    private int statusCode;

    public ResponseObjectDto(T data, int statusCode) {
        this.data = data;
        this.statusCode = statusCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

}
