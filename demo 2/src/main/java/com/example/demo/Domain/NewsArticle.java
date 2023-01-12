package com.example.demo.Domain;

import java.sql.Blob;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * A NewsArticle.
 */

@Setter
@Getter
@Entity
public class NewsArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String author;

    private String article;

    private Blob image;

    private Genre genre;

    private LocalDate date;

    private Integer likes;

    // @OneToMany(mappedBy = "newsArticle")
    // @JsonIgnoreProperties(value = { "newsArticle", "user" }, allowSetters = true)
    // private Set<Comment> Comments = new HashSet<>();

}
