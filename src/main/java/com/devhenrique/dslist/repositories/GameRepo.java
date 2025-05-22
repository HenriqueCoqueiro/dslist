package com.devhenrique.dslist.repositories;

import com.devhenrique.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepo extends JpaRepository<Game, Long> {
}
