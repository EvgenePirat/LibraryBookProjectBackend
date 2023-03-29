package com.example.backend.Booksbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class LibraryUserKey implements Serializable {
    public LibraryUserKey() {}
    public LibraryUserKey(Long userId, Long bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    @Column(name = "user_id")
    private Long userId;


    @Column(name = "book_id")
    private Long bookId;

}
