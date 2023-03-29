package com.example.backend.Booksbackend.service;

import com.example.backend.Booksbackend.entity.RatingBook;
import com.example.backend.Booksbackend.repository.RatingBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    RatingBookRepository ratingBookRepository;

    public boolean processSaveOrUpdateRatingInBD(RatingBook ratingBookFromFrontend){
        if(checkAlreadyRatingInBd(ratingBookFromFrontend) == false){
            ratingBookRepository.save(ratingBookFromFrontend);
            return true;
        }
        processUpdateRatingInBD(ratingBookFromFrontend);
        return false;
    }
    public float getAverageRatingForBook(Long bookId){
        List<RatingBook> ratingBookList = ratingBookRepository.getRatingBookByBookId(bookId);
        if(ratingBookList.size() > 0){
            double sum = ratingBookList.stream().mapToDouble(RatingBook::getRating).sum();
            int count = (int) ratingBookList.stream().count();
            return (float) sum/count;
        }
        return 0;
    }
    @Transactional
    public void processUpdateRatingInBD(RatingBook ratingBookFromFrontend){
        ratingBookRepository.updateValue(ratingBookFromFrontend.getBook().getId(),ratingBookFromFrontend.getUser().getId(),ratingBookFromFrontend.getRating());
    }
    private boolean checkAlreadyRatingInBd(RatingBook ratingBookFromFrontend){
        RatingBook ratingBookFromDB = ratingBookRepository.getRatingBookByBookIdAndUserId(ratingBookFromFrontend.getBook().getId(),ratingBookFromFrontend.getUser().getId());
        if(ratingBookFromDB == null){
            System.out.println("Hello");
            return false;
        }
        return true;
    }
}
