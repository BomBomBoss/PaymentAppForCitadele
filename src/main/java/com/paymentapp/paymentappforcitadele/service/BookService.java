package com.paymentapp.paymentappforcitadele.service;

import com.paymentapp.paymentappforcitadele.models.Book;
import com.paymentapp.paymentappforcitadele.models.Person;
import com.paymentapp.paymentappforcitadele.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
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
    public Book findById(String type, int id) {
//        return (Book) findByType(type).stream().filter(book -> book.getId()==id);
        Set<Book> set = findByType(type);
        for(Book b : set) {
            if (b.getId()==id) return b;
        }
        return null;
    }

}
