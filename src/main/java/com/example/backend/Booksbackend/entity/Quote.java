package com.example.backend.Booksbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "text",nullable = false,unique = true, length = 700)
    private String text;

    @ManyToOne
    @JoinColumn(name = "author_id",nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    private Book book;
}
