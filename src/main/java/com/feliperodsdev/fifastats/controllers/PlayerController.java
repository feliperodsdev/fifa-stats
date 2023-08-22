package com.feliperodsdev.fifastats.controllers;

import com.feliperodsdev.fifastats.controllers.dtos.HttpResponseDto;
import com.feliperodsdev.fifastats.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
