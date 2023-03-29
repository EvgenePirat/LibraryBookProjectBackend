package com.example.backend.Booksbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "users")
@Data
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "login",nullable = false, unique = true)
    private String login;
    @Column(name = "password", nullable = false, length = 1000)
    private String password;
    @Column(name = "date_create")
    private LocalDateTime dateOfCreate;
    @PrePersist
    private void init(){
        dateOfCreate = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LibraryUser> libraryBooksSet;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<RatingBook> ratingBooks;

}
