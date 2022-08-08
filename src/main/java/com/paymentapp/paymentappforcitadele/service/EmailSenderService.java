package com.paymentapp.paymentappforcitadele.service;

import com.paymentapp.paymentappforcitadele.models.BankCard;
import com.paymentapp.paymentappforcitadele.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Service
public class EmailSenderService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public String sendEmail(BankCard bankCard) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("vladjuha13@gmail.com");

        Book book = bankCard.getPerson().getBook();
        String mailTo = bankCard.getPerson().getEmail();
        String subject = "Payment confirmation";
        String body = "Dear, " + bankCard.getPerson().getName() + ", your payment was performed with card ****" +
                bankCard.getCardNumber().substring(12,16) + " at this date: "+ LocalDate.now()
                + " and time: " + LocalTime.now().truncatedTo(ChronoUnit.MINUTES) +"\n\rBook title: " + book.getTitle()
                + "\n\rAuthor: " + book.getAuthor() + "\n\rBook Price: " + book.getPrice() + "$";

        message.setTo(mailTo);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        return "Mail was sent";
    }

}
