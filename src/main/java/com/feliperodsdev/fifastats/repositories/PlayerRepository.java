package com.feliperodsdev.fifastats.repositories;

import com.feliperodsdev.fifastats.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Qualifier("PgPlayerRepo")
public class PlayerRepository implements IPlayerRepository {

    @Autowired
    PlayerRepositoryPg playerRepository;

    @Override
    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public void createPlayer(Player player) {
        playerRepository.save(player);
    }
}
