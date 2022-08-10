package com.paymentapp.paymentappforcitadele.service;

import com.paymentapp.paymentappforcitadele.models.Person;
import com.paymentapp.paymentappforcitadele.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @MockBean
    private PersonRepository personRepository;

    @Test
    void savePerson() {
        Person person = new Person("Name1", "Surname2", "test@mail.com");
        when(personRepository.save(person)).thenReturn(person);
        assertEquals(person, personService.savePerson(person));
    }

}