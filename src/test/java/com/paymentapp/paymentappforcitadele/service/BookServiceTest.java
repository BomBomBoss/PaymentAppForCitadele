package com.paymentapp.paymentappforcitadele.service;

import com.paymentapp.paymentappforcitadele.models.Book;
import com.paymentapp.paymentappforcitadele.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;


    @Test
    void findByType() {
        String type = "classic";
        when(bookRepository.findAllByBookType(type)).thenReturn(Stream.of(new Book("Test1","Author1", 1900, "classic",
                20.0), new Book("Test2","Author2",2000, "classic",10.0)).collect(Collectors.toList()));
        assertEquals(2, bookService.findByType(type).size());
    }

}