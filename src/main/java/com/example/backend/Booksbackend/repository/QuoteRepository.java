package com.example.backend.Booksbackend.repository;

import com.example.backend.Booksbackend.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote,Long> {
}
