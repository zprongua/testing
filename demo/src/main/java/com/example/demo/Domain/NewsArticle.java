package com.example.demo.Domain;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

/**
 * A NewsArticle.
 */

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "news_article")
public class NewsArticle implements Serializable {

    private static final long serialVersionUID = 1L;

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
