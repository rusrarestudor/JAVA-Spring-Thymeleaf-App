package com.sdproject.finalproject.server.model.CQRS.events.commands;

import com.sdproject.finalproject.server.model.House;

public class UpdateHouseEvent {
    private House house;
    private String user;

    public House getHouse() {
        return house;
    }

    public String getUser() {
        return user;
    }

    public UpdateHouseEvent(House house, String user) {
        this.house = house;
        this.user = user;
    }
}
