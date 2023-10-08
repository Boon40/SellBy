package com.sellby.sellby.repository;

import com.sellby.sellby.models.Comment;
import com.sellby.sellby.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT c FROM Comment c WHERE c.receiver = ?1")
    List<Comment> GetAllUserComments(User receiver);

}
