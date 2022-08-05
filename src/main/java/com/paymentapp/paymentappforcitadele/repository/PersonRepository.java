package com.paymentapp.paymentappforcitadele.repository;


import com.paymentapp.paymentappforcitadele.models.Person;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

//in this app collections will be used instead of Data Base
@Component
public class PersonRepository {
    public Set<Person> personSet = new HashSet<>();

    public PersonRepository() {
    }
}
