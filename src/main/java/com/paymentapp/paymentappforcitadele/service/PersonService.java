package com.paymentapp.paymentappforcitadele.service;

import com.paymentapp.paymentappforcitadele.models.Person;
import com.paymentapp.paymentappforcitadele.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void savePerson(Person person) {
        personRepository.personSet.add(person);
    }

    public void showAll() {
        System.out.println(personRepository.personSet.toString());
    }

}
