package com.sdproject.finalproject.server.service;

import com.sdproject.finalproject.server.model.House;
import com.sdproject.finalproject.server.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public List<House> getUserHouses(String nume);
}
