package com.example.backend.Booksbackend.service;

import com.example.backend.Booksbackend.entity.Book;
import com.example.backend.Booksbackend.entity.LibraryUser;
import com.example.backend.Booksbackend.entity.LibraryUserKey;
import com.example.backend.Booksbackend.entity.User;
import com.example.backend.Booksbackend.repository.LibraryRepository;
import com.example.backend.Booksbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    LibraryRepository libraryRepository;
    public boolean checkUserForRegistration(User user){
        if(userRepository.findByLogin(user.getLogin()) != null){
            return false;
        }
            userRepository.save(user);
        return true;
    }

    public boolean checkUserInEnterToSystem(User user){
        User userFromDB = userRepository.findByLogin(user.getLogin());
        if(userFromDB != null && userFromDB.getPassword().equals(user.getPassword()) == true){
            return true;
        }
        return false;
    }

    public boolean addBookInLibraryUser(LibraryUserKey libraryUserKey){
        if(checkBookIdInLibraryYet(libraryUserKey) == false){
            return false;
        }
        User user = new User();
        user.setId(libraryUserKey.getUserId());
        Book book = new Book();
        book.setId(libraryUserKey.getBookId());
        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setUser(user);
        libraryUser.setBook(book);
        libraryUser.setId(libraryUserKey);
        libraryRepository.save(libraryUser);
        return true;
    }

    private boolean checkBookIdInLibraryYet(LibraryUserKey libraryUserKey){
        User userFromDb = userRepository.getById(libraryUserKey.getUserId());
        if(userFromDb == null){
            return false;
        }
        List<LibraryUser> collectionBooks = userFromDb.getLibraryBooksSet();
        List<Book> collectionBooksForUser = collectionBooks.stream()
                .filter(LibraryUser-> LibraryUser.getUser().getId() == userFromDb.getId())
                .map(LibraryUser::getBook).toList();
        for(Book book: collectionBooksForUser){
            if(book.getId() == libraryUserKey.getBookId()){
                return false;
            }
        }
        return true;
    }
}
