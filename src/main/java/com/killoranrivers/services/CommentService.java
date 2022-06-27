package com.killoranrivers.services;

import com.killoranrivers.models.Comment;
import com.killoranrivers.models.Game;
import com.killoranrivers.repositories.CommentRepository;
import com.killoranrivers.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    private final GameRepository gameRepository;

    @Autowired // Constructor based dependency injection
    public CommentService(CommentRepository commentRepository, GameRepository gameRepository) {
        this.commentRepository = commentRepository;
        this.gameRepository = gameRepository;
    }

    public List<Comment> getGameComments(Integer gameId) {
        return commentRepository.findCommentsByGameId(gameId);
    }

    public void addGameComment(Integer gameId, Comment newComment, Game game) {
        // Check if game exists in database (meaning it already has comments tied to it)
        Optional<Game> gameOptional = gameRepository.findById(gameId);

        if(!gameOptional.isPresent()) {
            // Save comment to comments table & include associated gameId
            newComment.setGame(game);
            commentRepository.save(newComment);
        } else {
            // Save the comment & link it to already existing game
            Game existingGame = gameOptional.get();
            newComment.setGame(existingGame);
            commentRepository.save(newComment);
        }
    }
}
