package com.devhenrique.dslist.controllers;

import com.devhenrique.dslist.dto.GameMinDto;
import com.devhenrique.dslist.servicies.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping
    public List<GameMinDto> findAll(){
        return gameService.findAll();
    }
}
