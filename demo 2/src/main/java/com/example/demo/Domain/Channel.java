package com.example.demo.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A channel, User Genre Preferences.
 */

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
public class Channel {

    @Id
    private Long userId;

    @Enumerated(EnumType.STRING)
    private Genre preferences;
}
