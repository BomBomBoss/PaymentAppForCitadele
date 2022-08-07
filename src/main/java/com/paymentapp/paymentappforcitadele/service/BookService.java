package com.paymentapp.paymentappforcitadele.service;

import com.paymentapp.paymentappforcitadele.models.Book;
import com.paymentapp.paymentappforcitadele.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Set<Book> findByType(String type) {
        return bookRepository.getBooksDB().get(type);
    }
}
