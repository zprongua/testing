package com.example.demo.Domain;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * A NewsArticle.
 */

@Setter
@Getter
@Entity
public class NewsArticle implements Serializable {

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

    @OneToMany(mappedBy = "newsArticle")
    @JsonIgnoreProperties(value = { "newsArticle", "user" }, allowSetters = true)
    private Set<Comment> Comments = new HashSet<>();
}
