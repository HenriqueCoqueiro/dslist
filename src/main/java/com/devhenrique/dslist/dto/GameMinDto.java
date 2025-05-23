package com.devhenrique.dslist.dto;

import com.devhenrique.dslist.entities.Game;

public class GameMinDto {
    private long id;
    private String title;
    private String imgUrl;
    private String shortDescription;

    public GameMinDto(){
    }

    public GameMinDto(Game entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImgUrl() {
        return imgUrl;
    }


    public String getShortDescription() {
        return shortDescription;
    }
}
