package com.paymentapp.paymentappforcitadele.repository;

import com.paymentapp.paymentappforcitadele.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


//all books will be entered to H2 DB when application runs. Script in resources/data.sql file
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
     List<Book> findAllByBookType(String type);
}
