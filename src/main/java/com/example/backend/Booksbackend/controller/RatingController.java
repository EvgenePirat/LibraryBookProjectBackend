package com.example.backend.Booksbackend.controller;

import com.example.backend.Booksbackend.entity.RatingBook;
import com.example.backend.Booksbackend.repository.RatingBookRepository;
import com.example.backend.Booksbackend.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rating")
@CrossOrigin("http://localhost:3000/")
public class RatingController {
    @Autowired
    RatingBookRepository ratingBookRepository;
    @Autowired
    RatingService ratingService;
    @PostMapping("/save_rating")
    public ResponseEntity saveNewRatingForBook(@RequestBody RatingBook ratingBook){
        if(ratingService.processSaveOrUpdateRatingInBD(ratingBook)){
            return new ResponseEntity(HttpStatus.CREATED);
        }else {
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    @GetMapping("get_rating_for_book/{bookId}/{userId}")
    public RatingBook getRatingForBook(@PathVariable Long bookId, @PathVariable Long userId){
        return ratingBookRepository.getRatingBookByBookIdAndUserId(bookId,userId);
    }

    @GetMapping("get_average_rating/{bookId}")
    public float getAverageRatingForBookOnFront(@PathVariable Long bookId){
        return ratingService.getAverageRatingForBook(bookId);
    }

}
