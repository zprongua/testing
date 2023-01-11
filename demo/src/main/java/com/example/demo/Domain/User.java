package com.example.demo.Domain;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.example.demo.Config.Constants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A user.
 */
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 4, message = "*Your user name must have at least 4 characters")
    @Column(length = 50, unique = true, nullable = false)
    @NotEmpty(message = "*Please provide a user name")
    private String login;

    @JsonIgnore
    @NotNull
    @Size(min = 5, max = 60, message = "*Your password must have at least 5 characters")
    @Column(name = "password", length = 60, nullable = false)
    @NotEmpty(message = "*Please provide your password")
    private String password;

    @Size(max = 50)
    @Column(name = "first_name", length = 50)
    @NotEmpty(message = "*Please provide your name")
    private String firstName;

    @Size(max = 50)
    @Column(name = "last_name", length = 50)
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;

    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    @Size(min = 5, max = 254)
    @Column(length = 254, unique = true)
    private String email;

    @Size(max = 256)
    @Column(name = "image_url", length = 256)
    private String imageUrl;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "user_authority", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "authority_name", referencedColumnName = "name") })
    @Builder.Default
    private Set<Authority> authorities = new HashSet<>();
}