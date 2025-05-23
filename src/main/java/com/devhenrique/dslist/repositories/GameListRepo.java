package com.devhenrique.dslist.repositories;

import com.devhenrique.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepo extends JpaRepository<GameList, Long> {
}
