package com.example.backend.Booksbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false, unique = true)
    private String name;
    @Column(name = "image", nullable = false, unique = true)
    private String url;
    @Column(name = "release_year", nullable = false)
    private int yearRelease;
    @Column(name = "language",nullable = false)
    private String language;
    @Column(name = "count_pages",nullable = false)
    private int numberPages;
    @Column(name = "description", nullable = false, length = 1300)
    private String description;
    @Column(name = "download_url",nullable = false,length = 500)
    private String urlDownload;


    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<LibraryUser> userSet;

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    private Set<Quote> quotes;

    @JsonIgnore
    @OneToMany(mappedBy = "book",cascade = CascadeType.REMOVE)
    private List<RatingBook> ratingBooks;
}
