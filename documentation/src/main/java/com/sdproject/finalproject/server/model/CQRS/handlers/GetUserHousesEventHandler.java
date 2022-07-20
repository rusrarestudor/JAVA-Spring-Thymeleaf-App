package com.sdproject.finalproject.server.model.CQRS.handlers;

import com.sdproject.finalproject.server.model.CQRS.events.commands.GetUserHousesEvent;
import com.sdproject.finalproject.server.model.House;
import com.sdproject.finalproject.server.repository.HouseRepo;
import com.sdproject.finalproject.server.repository.UserRepo;
import com.sdproject.finalproject.server.service.UserServiceImpl;

import java.util.List;

public class GetUserHousesEventHandler {
    private HouseRepo houseRepo;
    private UserRepo userRepo;
    public GetUserHousesEventHandler(HouseRepo houseRepo,UserRepo userRepo) {
        this.userRepo = userRepo;
        this.houseRepo = houseRepo;
    }

    public List<House> handle(GetUserHousesEvent event){
        UserServiceImpl houseService = new  UserServiceImpl(userRepo, houseRepo);
        return houseService.getUserHouses(event.getUser());
    }
}
