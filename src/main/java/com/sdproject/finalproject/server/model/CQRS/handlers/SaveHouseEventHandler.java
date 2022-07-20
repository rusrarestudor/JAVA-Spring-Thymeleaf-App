package com.sdproject.finalproject.server.model.CQRS.handlers;

import com.sdproject.finalproject.server.model.CQRS.events.commands.RegisterEvent;
import com.sdproject.finalproject.server.model.CQRS.events.commands.SaveHouseEvent;
import com.sdproject.finalproject.server.model.House;
import com.sdproject.finalproject.server.model.User;
import com.sdproject.finalproject.server.repository.HouseRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SaveHouseEventHandler {
    private HouseRepo houseRepo;

    public SaveHouseEventHandler(HouseRepo houseRepo){
        this.houseRepo = houseRepo;
    }

    public String handle(SaveHouseEvent event){
        String user = event.getUser();
        House house = event.getHouse();
        house.setOwnedBy(user);
        houseRepo.save(house);

        return "OK";
    }
}
