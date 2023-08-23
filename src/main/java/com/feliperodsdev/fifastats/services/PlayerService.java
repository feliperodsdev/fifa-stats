package com.feliperodsdev.fifastats.services;

import com.feliperodsdev.fifastats.model.Player;
import com.feliperodsdev.fifastats.repositories.IPlayerRepository;
import com.feliperodsdev.fifastats.services.dtos.CreatePlayerServiceDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private IPlayerRepository playerRepository;

    public PlayerService(@Qualifier("PgPlayerRepo") IPlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public Player createPlayer(CreatePlayerServiceDto createPlayerServiceDto){
        Player player = Player.create(createPlayerServiceDto.getName());
        playerRepository.createPlayer(player);
        return player;
    }

    public Player getPlayer(Long id){
        return playerRepository.getPlayerById(id).orElseThrow(() -> new IllegalArgumentException("Not Found"));
    }

}
