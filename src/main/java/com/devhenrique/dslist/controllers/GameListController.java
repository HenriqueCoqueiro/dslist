package com.devhenrique.dslist.controllers;

import com.devhenrique.dslist.dto.GameListDto;
import com.devhenrique.dslist.dto.GameMinDto;
import com.devhenrique.dslist.dto.ReplacementDto;
import com.devhenrique.dslist.servicies.GameListService;
import com.devhenrique.dslist.servicies.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDto> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDto> findByList(@PathVariable Long listId){
        List<GameMinDto> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId,@RequestBody ReplacementDto body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }

}
