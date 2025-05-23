package com.devhenrique.dslist.servicies;

import com.devhenrique.dslist.dto.GameListDto;
import com.devhenrique.dslist.repositories.GameListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepo gameListRepo;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll(){
        return gameListRepo.findAll().stream().map(GameListDto::new).toList();
    }
}
