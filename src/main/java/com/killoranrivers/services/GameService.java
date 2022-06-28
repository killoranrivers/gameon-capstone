package com.killoranrivers.services;

import com.killoranrivers.models.Game;
import com.killoranrivers.repositories.CommentRepository;
import com.killoranrivers.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService {
    private final GameRepository gameRepository;

    @Autowired // Constructor based dependency injection
    public GameService(CommentRepository commentRepository, GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

//    public Optional<Game> getGameById(Integer gameId) {
//        return gameRepository.findById(gameId);
//    }
}
