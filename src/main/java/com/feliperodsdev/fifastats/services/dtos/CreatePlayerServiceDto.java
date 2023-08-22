package com.feliperodsdev.fifastats.services.dtos;

import java.util.Date;

public class CreatePlayerServiceDto {

    private String name;

    public CreatePlayerServiceDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
