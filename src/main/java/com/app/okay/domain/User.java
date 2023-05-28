package com.app.okay.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private long userId;

    @NotBlank
    private String name;

    @Email
    @NotNull
    private String email;

    @NotBlank
    private String password;

    @ManyToMany
    @JoinTable(name = "user_relation")
    private Set<User> relatedUsers;
}
