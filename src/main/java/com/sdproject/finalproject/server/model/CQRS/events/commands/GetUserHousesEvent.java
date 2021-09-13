package com.sdproject.finalproject.server.model.CQRS.events.commands;

import com.sdproject.finalproject.server.model.User;

public class GetUserHousesEvent {
    private String name;

    public GetUserHousesEvent(String name){
        this.name = name;
    }

    public String getUser() {
        return name;
    }
}
