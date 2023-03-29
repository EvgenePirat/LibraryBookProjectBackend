package com.example.backend.Booksbackend.repository;

import com.example.backend.Booksbackend.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
