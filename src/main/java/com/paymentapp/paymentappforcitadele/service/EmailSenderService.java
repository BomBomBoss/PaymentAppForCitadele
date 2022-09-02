package com.paymentapp.paymentappforcitadele.service;


import com.paymentapp.paymentappforcitadele.models.Book;
import com.paymentapp.paymentappforcitadele.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;


//Service class for sending email with correct data after performing book purchase
@Service
public class EmailSenderService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(Person person) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("YOURMAIL@gmail.com");

        Book book = person.getBook();
        String mailTo = person.getEmail();
        String subject = "Payment confirmation";
        //Body will consist of customer's Name, last 4 digits if his bank card to verify that it's truly his purchase, date and time when customer performed payment ,
        // and purchased book information, like title,author and price
        String body = "Dear, " + person.getName() + ", your payment was performed by card ****" +
        person.getCardLastFourDigits() + " on: "+ LocalDate.now()
                + " and at : " + LocalTime.now().truncatedTo(ChronoUnit.MINUTES)  +"\n\rBook: " + book.getTitle()
                + "\n\rAuthor: " + book.getAuthor() + "\n\rPrice: " + book.getPrice() + "$";

        message.setTo(mailTo);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
    }

}
