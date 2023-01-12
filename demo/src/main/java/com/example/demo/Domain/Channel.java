package com.example.demo.Domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * A channel, User Genre Preferences.
 */
@Setter
@Getter
@Entity
public class Channel implements Serializable {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Genre preference;

    @ManyToOne
    @JoinColumn(unique = false)
    private User user;

    public Channel id(Long id) {
        this.setId(id);
        return this;
    }

    public Channel preference(Genre preference) {
        this.setPreference(preference);
        return this;
    }

    public Channel user(User user) {
        this.setUser(user);
        return this;
    }
}
