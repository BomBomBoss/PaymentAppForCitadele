package com.paymentapp.paymentappforcitadele.service;

import com.paymentapp.paymentappforcitadele.models.Book;
import com.paymentapp.paymentappforcitadele.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//Service for Book model to work with Book table transactions in DB
@Service
@Transactional(readOnly = true)
public class BookService {


    private final BookRepository bookRepository;

    @Autowired
    public BookService( BookRepository bookDBRepository) {
        this.bookRepository = bookDBRepository;
    }

    public List<Book> findByType(String type) {
        return bookRepository.findAllByBookType(type);
    }

    public Book findById(int id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

}
