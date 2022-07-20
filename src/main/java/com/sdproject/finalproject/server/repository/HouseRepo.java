package com.sdproject.finalproject.server.repository;

import com.sdproject.finalproject.server.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepo extends JpaRepository<House, Long> {

    @Query("SELECT h FROM House h WHERE h.id IS NOT NULL")
    List<House> getAll ();
}
