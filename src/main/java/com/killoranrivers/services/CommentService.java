package com.killoranrivers.services;

import com.killoranrivers.models.Comment;
import com.killoranrivers.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getGameComments(Long gameId) {
        return commentRepository.findCommentsByGameId(gameId);
    }
}
