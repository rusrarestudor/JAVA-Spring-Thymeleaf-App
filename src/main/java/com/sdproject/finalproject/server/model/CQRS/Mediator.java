package com.sdproject.finalproject.server.model.CQRS;

import com.sdproject.finalproject.server.model.CQRS.events.commands.RegisterEvent;
import com.sdproject.finalproject.server.model.CQRS.events.commands.SaveHouseEvent;
import com.sdproject.finalproject.server.model.CQRS.events.commands.UpdateHouseEvent;
import com.sdproject.finalproject.server.model.CQRS.events.queries.GetHousesEvent;
import com.sdproject.finalproject.server.model.CQRS.events.commands.GetUserHousesEvent;
import com.sdproject.finalproject.server.model.CQRS.handlers.*;
import com.sdproject.finalproject.server.repository.HouseRepo;
import com.sdproject.finalproject.server.repository.UserRepo;

public class Mediator {
    private UserRepo userRepo;
    private HouseRepo houseRepo;


    public Mediator(UserRepo userRepo, HouseRepo houseRepo){
        this.userRepo = userRepo;
        this.houseRepo = houseRepo;
    }

    public <T,X>  T handle(X event){
        if(event instanceof RegisterEvent){
            return (T) new RegisterEventHandler(userRepo).handle((RegisterEvent) event);
        }
        if(event instanceof GetHousesEvent){
            return (T) new GetHousesEventHandler(houseRepo).handle((GetHousesEvent) event);
        }
        if(event instanceof GetUserHousesEvent){
            return (T) new GetUserHousesEventHandler(houseRepo,userRepo).handle((GetUserHousesEvent) event);
        }
        if(event instanceof SaveHouseEvent){
            return (T) new SaveHouseEventHandler(houseRepo).handle((SaveHouseEvent) event);
        }
        if(event instanceof UpdateHouseEvent){
            return (T) new UpdateHouseEventHandler(houseRepo).handle((UpdateHouseEvent) event);
        }

        return null;
    }
}
