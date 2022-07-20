package com.sdproject.finalproject;

import com.sdproject.finalproject.server.model.House;
import com.sdproject.finalproject.server.model.User;
import com.sdproject.finalproject.server.repository.HouseRepo;
import com.sdproject.finalproject.server.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ReposTest {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private HouseRepo houseRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindUserByEmail(){
        String email = "rares@gmail.com";
        User user = userRepo.findByEmail(email);
        assertThat(user).isNotNull();
    }

    @Test
    public void testAddHouseToUser(){
        House h = new House();
        h.setAddress("Cluj, Ro");
        h.setNoRooms(6);
        h.setPrice(800000);
        h.setType("house");

        User u = userRepo.findByEmail("rares@gmail.com");
    }

    @Test
    public void test(){
        String email = "rares@gmail.com";
        User user = userRepo.findByEmail(email);
        assertThat(user).isNotNull();
    }

}
