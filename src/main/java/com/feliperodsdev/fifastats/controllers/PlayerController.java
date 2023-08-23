package com.feliperodsdev.fifastats.controllers;

import com.feliperodsdev.fifastats.controllers.dtos.CreatePlayerControllerDto;
import com.feliperodsdev.fifastats.controllers.dtos.HttpResponseDto;
import com.feliperodsdev.fifastats.services.PlayerService;
import com.feliperodsdev.fifastats.services.dtos.CreatePlayerServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/get-player/{id}")
    public ResponseEntity<Object> getPlayer(@PathVariable("id") Long id){
        HttpResponseDto response = new HttpResponseDto();

        HttpHeaders headers = new HttpHeaders();
        headers.add("date-time", LocalDateTime.now().toString());

        return response.ok(playerService.getPlayer(id), headers, MediaType.APPLICATION_JSON);

    }

    @RequestMapping("/create-player")
    public ResponseEntity<Object> createPlayer(@RequestBody CreatePlayerControllerDto createPlayerControllerDto){
        HttpResponseDto response = new HttpResponseDto();

        String[] requiredFields = {"name"};

        HttpHeaders headers = new HttpHeaders();
        headers.add("date-time", LocalDateTime.now().toString());

        for (String field : requiredFields) {
            try {
                Field declaredField = createPlayerControllerDto.getClass().getDeclaredField(field);
                declaredField.setAccessible(true);
                if (declaredField.get(createPlayerControllerDto) == null) {
                    return response.badRequest("Missing Param: " + field, headers, MediaType.APPLICATION_JSON);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                return response.serverError(e.getMessage());
            }
        }

        playerService.createPlayer(new CreatePlayerServiceDto(createPlayerControllerDto.getName()));

        return response.created("created", headers, MediaType.APPLICATION_JSON);
    }

}
