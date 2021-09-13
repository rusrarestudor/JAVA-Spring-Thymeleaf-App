package com.sdproject.finalproject.server.model.CQRS.events.commands;

import com.sdproject.finalproject.server.model.User;

public class RegisterEvent {
    private User user;

    public RegisterEvent(User user){
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
