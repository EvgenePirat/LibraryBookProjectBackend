package com.example.backend.Booksbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false, unique = true)
    private String name;
    @Column(name = "photoURL", unique = true, length = 500)
    private String urlImage;
    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @JsonIgnore
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "author")
    private Set<Book> books;

    @JsonIgnore
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "author",cascade = CascadeType.REMOVE)
    private Set<Quote> quotes;
}
