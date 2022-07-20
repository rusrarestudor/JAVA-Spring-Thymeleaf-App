package com.sdproject.finalproject.server.model.CQRS.handlers;

import com.sdproject.finalproject.server.model.CQRS.events.commands.SaveHouseEvent;
import com.sdproject.finalproject.server.model.CQRS.events.commands.UpdateHouseEvent;
import com.sdproject.finalproject.server.model.House;
import com.sdproject.finalproject.server.repository.HouseRepo;

public class UpdateHouseEventHandler {
    private HouseRepo houseRepo;

    public UpdateHouseEventHandler(HouseRepo houseRepo) {
        this.houseRepo = houseRepo;
    }

    public String handle(UpdateHouseEvent event){
        String user = event.getUser();
        House house = event.getHouse();
        houseRepo.deleteById(house.getId());
        house.setOwnedBy(user);
        houseRepo.save(house);

        return "OK";
    }
}
