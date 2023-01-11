package com.example.demo.Repository;

import java.util.Optional;

import com.example.demo.Domain.NewsArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface NewsArticleRepository extends JpaRepository<NewsArticle, Long> {
    Optional<NewsArticle> findById(Long Id);
}
