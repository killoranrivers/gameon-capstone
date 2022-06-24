package com.killoranrivers.repositories;

import com.killoranrivers.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    // Custom queries here
    // Get all games with recent comments, LIMIT 8
}