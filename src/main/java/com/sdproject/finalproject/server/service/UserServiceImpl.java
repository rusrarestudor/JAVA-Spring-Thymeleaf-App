package com.sdproject.finalproject.server.service;

import com.sdproject.finalproject.server.model.House;
import com.sdproject.finalproject.server.model.User;
import com.sdproject.finalproject.server.repository.HouseRepo;
import com.sdproject.finalproject.server.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private HouseRepo houseRepo;

    public UserServiceImpl(UserRepo userRepo, HouseRepo houseRepo) {
        this.userRepo = userRepo;
        this.houseRepo = houseRepo;
    }

    @Override
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @Override
    public List<House> getUserHouses(String nume){
        List<House> houses = new ArrayList<>();
        int j=0;
        if (houseRepo.getAll().size() == 0){
            return Collections.emptyList();
        }else{
            while(j < houseRepo.getAll().size()){
                if (houseRepo.findAll().get(j).getOwnedBy().equals(nume)) {
                    houses.add(houseRepo.getAll().get(j));
                }
                j++;
            }
            return houses;
        }
    }

}
