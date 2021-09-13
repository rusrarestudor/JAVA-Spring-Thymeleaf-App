package com.sdproject.finalproject.server.controller;

import com.sdproject.finalproject.server.model.CQRS.Mediator;
import com.sdproject.finalproject.server.model.CQRS.events.commands.RegisterEvent;
import com.sdproject.finalproject.server.model.CQRS.events.commands.SaveHouseEvent;
import com.sdproject.finalproject.server.model.CQRS.events.commands.UpdateHouseEvent;
import com.sdproject.finalproject.server.model.CQRS.events.queries.GetHousesEvent;
import com.sdproject.finalproject.server.model.CQRS.events.commands.GetUserHousesEvent;
import com.sdproject.finalproject.server.model.House;
import com.sdproject.finalproject.server.model.User;
import com.sdproject.finalproject.server.repository.HouseRepo;
import com.sdproject.finalproject.server.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private HouseRepo houseRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user){

        RegisterEvent event = new RegisterEvent(user);
        new Mediator(userRepo, houseRepo).handle(event);

        return "register_success";
    }

    @PostMapping("/saveHouse")
    public String saveHouse(@ModelAttribute("house") House house){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        SaveHouseEvent event = new SaveHouseEvent(house,username);
        new Mediator(userRepo, houseRepo).handle(event);

        return "redirect:/users";
    }

    @PostMapping("/updateHouse")
    public String updateHouse(@ModelAttribute("house") House house){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        UpdateHouseEvent event = new UpdateHouseEvent(house,username);
        new Mediator(userRepo, houseRepo).handle(event);

        return "redirect:/users";
    }

    @GetMapping("/showNewHouseForm")
    public String showNewHouseForm(Model model){

        House house = new House();
        model.addAttribute("house", house);

        return "new_house";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model){

        House house = houseRepo.getById(id);
        model.addAttribute("house", house);

        return "update_house";
    }

    @GetMapping("/deleteHouse/{id}")
    public String deleteHouse(@PathVariable (value = "id") long id, Model model){
        houseRepo.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String showUser(Model model1, Model model2){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        GetHousesEvent getHousesEvent = new GetHousesEvent();
        List<House> listHouses= new Mediator(userRepo, houseRepo).handle(getHousesEvent);

        GetUserHousesEvent getUserHousesEvent = new GetUserHousesEvent(username);
        List<House> listUserHouses = new Mediator(userRepo,houseRepo).handle(getUserHousesEvent);

        model1.addAttribute("listHouses", listHouses);
        model2.addAttribute("listUserHouses", listUserHouses);

        return "users";
    }


}
