package com.sdproject.finalproject.server.service;

import com.sdproject.finalproject.server.model.House;
import com.sdproject.finalproject.server.model.User;
import com.sdproject.finalproject.server.repository.HouseRepo;
import com.sdproject.finalproject.server.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseServiceImpl implements HouseService{
    @Autowired
    private HouseRepo houseRepo;

    @Override
    public List<House> getAllHouses(){
        return houseRepo.findAll();
    }

    @Override
    public void saveHouse(House house){
        this.houseRepo.save(house);
    }

    @Override
    public House getHouseById(long id){
        Optional<House> optional = houseRepo.findById(id);
        House h = null;
        if(optional.isPresent()){
            h = optional.get();
        }else{
            throw new RuntimeException("house not found by id!");
        }
        return h;
    }

    @Override
    public void deleteHouseById(long id){
        houseRepo.deleteById(id);
    }
}
