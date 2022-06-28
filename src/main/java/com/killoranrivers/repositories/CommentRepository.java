package com.killoranrivers.repositories;

import com.killoranrivers.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
 // Custom queries here
    @Modifying(clearAutomatically=true, flushAutomatically=true)
    @Query("SELECT c FROM Comment c JOIN c.game g ON g.id = ?1") // game has to match the object variable I declared in the Comment model
    Set<Comment> findCommentsByGameId(Integer gameId); // gameId has to match the @PathVariable definition

//    @Modifying(clearAutomatically=true, flushAutomatically=true)
//    @Query("SELECT comment FROM comments WHERE userId = ?1")
//    Set<Comment> findCommentsByUserId(Integer userId);

    // Find 8 most recent comments and get their gameId and send it to Thymeleaf
    @Modifying(clearAutomatically=true, flushAutomatically=true)
    @Query(nativeQuery = true, value = "SELECT * FROM Comment c ORDER BY c.createdAt LIMIT 8")
    Set<Comment> findNewComments();
}
