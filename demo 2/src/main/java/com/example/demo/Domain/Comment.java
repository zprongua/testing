package com.example.demo.Domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Comment {
    String body;

    @Id
    String author;

    LocalDateTime timeStamp;
}
