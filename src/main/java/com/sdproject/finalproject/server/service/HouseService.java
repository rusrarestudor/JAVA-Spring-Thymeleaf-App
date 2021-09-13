package com.sdproject.finalproject.server.service;

import com.sdproject.finalproject.server.model.House;
import com.sdproject.finalproject.server.model.User;

import java.util.List;

public interface HouseService {
    public List<House> getAllHouses();
    void saveHouse(House house);
    House getHouseById(long id);
    void deleteHouseById(long id);
}
