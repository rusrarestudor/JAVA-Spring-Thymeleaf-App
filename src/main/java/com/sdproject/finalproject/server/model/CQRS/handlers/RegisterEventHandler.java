package com.sdproject.finalproject.server.model.CQRS.handlers;

import com.sdproject.finalproject.server.model.CQRS.events.commands.RegisterEvent;
import com.sdproject.finalproject.server.model.User;
import com.sdproject.finalproject.server.repository.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RegisterEventHandler {
    private UserRepo userRepo;

    public RegisterEventHandler(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public String handle(RegisterEvent event){
        User user = event.getUser();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "OK";
    }
}
