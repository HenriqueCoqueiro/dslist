package com.devhenrique.dslist.servicies;

import com.devhenrique.dslist.dto.GameMinDto;
import com.devhenrique.dslist.repositories.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepo gameRepo;

    public List<GameMinDto> findAll(){
        return gameRepo.findAll().stream().map(GameMinDto::new).toList();
    }
}
