package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Domain.NewsArticle;
import com.example.demo.Repository.NewsArticleRepository;

@Controller
@RequestMapping("/newsarticle")
public class NewsArticleController {

    @Autowired
    NewsArticleRepository newsArticleRepository;

    public NewsArticleController(NewsArticleRepository newsArticleRepository) {
        this.newsArticleRepository = newsArticleRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<NewsArticle>> getNewsArticles() {
        return new ResponseEntity<>(newsArticleRepository.findAll(), HttpStatus.OK);
    }
}
