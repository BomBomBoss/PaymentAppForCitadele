package com.paymentapp.paymentappforcitadele.repository;


import com.paymentapp.paymentappforcitadele.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByBookId(int id);

}
