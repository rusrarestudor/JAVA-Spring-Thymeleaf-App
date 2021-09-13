package com.sdproject.finalproject.server.model.CQRS.events.commands;

import com.sdproject.finalproject.server.model.House;

public class SaveHouseEvent {

    private House house;
    private String user;

    public SaveHouseEvent(House house, String user){
        this.house = house;
        this.user = user;
    }

    public String getUser() {
        return user;
    }
    public House getHouse() {
        return house;
    }
}
