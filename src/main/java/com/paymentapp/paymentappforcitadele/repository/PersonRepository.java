package com.paymentapp.paymentappforcitadele.repository;


import com.paymentapp.paymentappforcitadele.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByBookId(int id);

}
