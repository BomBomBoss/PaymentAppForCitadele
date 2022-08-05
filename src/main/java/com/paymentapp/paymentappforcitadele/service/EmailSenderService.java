package com.paymentapp.paymentappforcitadele.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public String sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("vladjuha13@gmail.com");
        message.setTo("vladjuha13@gmail.com");
        message.setText("Test body");
        message.setSubject("Test Subject");

        mailSender.send(message);
        return "Mail was sent";
    }

}
