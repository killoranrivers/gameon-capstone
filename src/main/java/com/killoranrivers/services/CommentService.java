package com.killoranrivers.services;

import com.killoranrivers.models.Comment;
import com.killoranrivers.models.Game;
import com.killoranrivers.models.User;
import com.killoranrivers.repositories.CommentRepository;
import com.killoranrivers.repositories.GameRepository;
import com.killoranrivers.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    private final GameRepository gameRepository;

    private final UserRepository userRepository;

    @Autowired // Constructor based dependency injection
    public CommentService(CommentRepository commentRepository, GameRepository gameRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
    }

    public Set<Comment> getGameComments(Integer gameId) {
        return commentRepository.findCommentsByGameId(gameId);
    }

    public Set<Comment> getNewComments() {
        return commentRepository.findNewComments();
    }

    public Set<Comment> getUserComments(Integer userId) {
        return commentRepository.findCommentsByUserId(userId);
    }

    public void addGameComment(Integer gameId, Integer userId, Comment newComment, User user, Game game) {
        // Check if game exists in database (meaning it already has comments tied to it)
        Optional<Game> gameOptional = gameRepository.findById(gameId);
        Optional<User> userOptional = userRepository.findById(userId);

        if(!gameOptional.isPresent()) {
            // Save comment to comments table & include associated gameId & userId
            newComment.setUser(user);
            newComment.setGame(game);
        } else {
            // Save the comment & link it to already existing game
            Game existingGame = gameOptional.get();
            User existingUser = userOptional.get();
            newComment.setUser(existingUser);
            newComment.setGame(existingGame);
        }

        commentRepository.save(newComment);
    }
}
