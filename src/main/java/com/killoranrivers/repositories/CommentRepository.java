package com.killoranrivers.repositories;

import com.killoranrivers.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
 // Custom queries here
    @Modifying(clearAutomatically=true, flushAutomatically=true)
    @Query("SELECT c FROM Comment c WHERE c.games.id = ?1")
    List<Comment> findCommentsByGameId(Long gameId);

//    @Modifying(clearAutomatically=true, flushAutomatically=true)
//    @Query("SELECT comment FROM comments WHERE userId = ?1")
//    List<Comment> findCommentsByUserId(Long userId);
}
