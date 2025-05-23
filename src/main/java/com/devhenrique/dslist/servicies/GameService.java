package com.devhenrique.dslist.servicies;

import com.devhenrique.dslist.dto.GameDto;
import com.devhenrique.dslist.dto.GameMinDto;
import com.devhenrique.dslist.entities.Game;
import com.devhenrique.dslist.projections.GameMinProjection;
import com.devhenrique.dslist.repositories.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepo gameRepo;

    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
        return gameRepo.findAll().stream().map(GameMinDto::new).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDto>  findByList(Long listId){
        return gameRepo.searchByList(listId).stream().map(GameMinDto::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDto findById(Long id){
        Game result = gameRepo.findById(id).get();
        GameDto dto = new GameDto(result);
        return dto;
    }

}
