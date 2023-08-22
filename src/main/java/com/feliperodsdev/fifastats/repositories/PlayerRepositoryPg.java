package com.feliperodsdev.fifastats.repositories;

import com.feliperodsdev.fifastats.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepositoryPg extends JpaRepository<Player, Long> {
}
