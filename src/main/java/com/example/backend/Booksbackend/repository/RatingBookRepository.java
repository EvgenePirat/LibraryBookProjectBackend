package com.example.backend.Booksbackend.repository;

import com.example.backend.Booksbackend.entity.RatingBook;
import com.example.backend.Booksbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RatingBookRepository extends JpaRepository<RatingBook,Long> {

    RatingBook getRatingBookByBookIdAndUserId(Long bookId, Long userId);

    List<RatingBook> getRatingBookByBookId(Long BookId);

    @Transactional
    @Modifying
    @Query("update RatingBook r set r.rating = :rating where r.book.id = :bookId and r.user.id = :userId")
    int updateValue(@Param("bookId") Long bookId, @Param("userId") Long userId, @Param("rating") Float rating);
}
