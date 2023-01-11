package com.example.demo.Repository;

import com.example.demo.Domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public interface CommentRepository extends JpaRepository<Comment, Long> {
    void setDate(LocalDateTime datetime);

    void delete(Long commentId);
}
