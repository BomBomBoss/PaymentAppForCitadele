package com.paymentapp.paymentappforcitadele.service;

import com.paymentapp.paymentappforcitadele.models.Person;
import com.paymentapp.paymentappforcitadele.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public Person savePerson(Person person) {
       return personRepository.save(person);
    }

    public Person findById (int id) {
        Optional<Person> person = personRepository.findById(id);
        return person.orElse(null);
    }
    public Person findByBookId(int id) {
        return personRepository.findByBookId(id);
    }

    public String hashGenerator(String cardNumber) {
        StringBuilder sb = new StringBuilder();
        DigestUtils.appendMd5DigestAsHex(cardNumber.getBytes(StandardCharsets.UTF_8), sb);
        return sb.toString();
    }



}
