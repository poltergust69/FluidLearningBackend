package com.uiktp.finki.ukim.fluidlearning.Models.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Users", schema = "dbo")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "username")
    private String username;

    @NotNull
    @NotEmpty
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "dateofbirth")
    private LocalDateTime dateOfBirth;

    @Column(name = "datecreated")
    private LocalDateTime dateCreated;

    @Column(name = "enabled")
    private Integer enabled;

    public Users() {
    }

    public Users(String firstName, String lastName, String username, String password, String role, LocalDateTime dateOfBirth, LocalDateTime dateCreated, Integer enabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.dateOfBirth = dateOfBirth;
        this.dateCreated = dateCreated;
        this.enabled = enabled;
    }
}