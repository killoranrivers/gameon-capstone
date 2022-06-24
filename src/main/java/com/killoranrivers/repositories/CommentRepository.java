package com.killoranrivers.repositories;

import com.killoranrivers.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
 // Custom queries here
    @Modifying(clearAutomatically=true, flushAutomatically=true)
    @Query("SELECT c FROM Comment c JOIN c.games g ON g.id = ?1")
    List<Comment> findCommentsByGameId(Integer gameId);

//    @Modifying(clearAutomatically=true, flushAutomatically=true)
//    @Query("SELECT comment FROM comments WHERE userId = ?1")
//    List<Comment> findCommentsByUserId(Integer userId);
}
