package com.example.demo.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Bookmark {
    @Id
    private Long id;

    // @ManyToMany
    @Column(name = "newsarticle_id")
    private Long newsarticleid;

    // @ManyToOne
    private Long userId;
}
