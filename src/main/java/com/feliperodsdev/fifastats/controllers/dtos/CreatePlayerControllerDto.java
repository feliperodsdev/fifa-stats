package com.feliperodsdev.fifastats.controllers.dtos;

public class CreatePlayerControllerDto {

    private String name;

    public CreatePlayerControllerDto(String name) {
        this.name = name;
    }

    public CreatePlayerControllerDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
