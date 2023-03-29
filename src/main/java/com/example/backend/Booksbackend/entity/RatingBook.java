package com.example.backend.Booksbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class RatingBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rating",nullable = false)
    private Float rating;
    @Column(name = "time_create",nullable = false)
    private LocalDateTime dateOfCreate;

    @PrePersist
    private void setTimeForRating(){
        dateOfCreate = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name="book_id",nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}
