package com.paymentapp.paymentappforcitadele.service;

import com.paymentapp.paymentappforcitadele.models.Person;
import com.paymentapp.paymentappforcitadele.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public Person findById (int id) {
        Optional<Person> person = personRepository.findById(id);
        return person.orElse(null);
    }
    public Person findByBookId(int id) {
        return personRepository.findByBookId(id);
    }



}
