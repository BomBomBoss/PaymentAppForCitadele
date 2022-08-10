package com.paymentapp.paymentappforcitadele.service;

import com.paymentapp.paymentappforcitadele.models.Person;
import com.paymentapp.paymentappforcitadele.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @MockBean
    private PersonRepository personRepository;

    @Test
    void savePerson() {
        Person person = new Person();

        boolean isSaved = personService.savePerson(person);
        Person person1 = personService.findById(1);
        Person person2 = personService.findById(2);
        Assert.isTrue(isSaved, "Saved");
        Assert.isNull(person2);
        Assert.notNull(person1);
    }

    @Test
    void findById() {
    }

    @Test
    void findByBookId() {
    }
}