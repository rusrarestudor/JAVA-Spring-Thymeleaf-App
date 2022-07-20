package com.sdproject.finalproject.server.model.CQRS.handlers;

import com.sdproject.finalproject.server.model.CQRS.events.queries.GetHousesEvent;
import com.sdproject.finalproject.server.model.House;
import com.sdproject.finalproject.server.repository.HouseRepo;

import java.util.List;

public class GetHousesEventHandler {
    private HouseRepo houseRepo;

    public GetHousesEventHandler(HouseRepo houseRepo) {
        this.houseRepo = houseRepo;
    }

    public List<House> handle(GetHousesEvent event){
        return houseRepo.getAll();
    }
}
