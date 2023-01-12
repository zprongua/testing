package com.example.demo.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * An authority (a security role) used by Spring Security.
 */

@Setter
@Getter
@Entity
public class Authority {

    @Id
    private String name;
}
