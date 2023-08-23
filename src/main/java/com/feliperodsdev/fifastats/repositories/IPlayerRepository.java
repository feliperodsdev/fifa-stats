package com.feliperodsdev.fifastats.repositories;

import com.feliperodsdev.fifastats.model.Player;

import java.util.Optional;

public interface IPlayerRepository {
    Optional<Player> getPlayerById(Long id);
    void createPlayer(Player player);
}
