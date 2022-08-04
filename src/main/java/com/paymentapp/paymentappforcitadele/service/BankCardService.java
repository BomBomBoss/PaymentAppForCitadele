package com.paymentapp.paymentappforcitadele.service;

import com.paymentapp.paymentappforcitadele.repository.BankCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankCardService {

    private final BankCardRepository bankCardRepository;

    @Autowired
    public BankCardService(BankCardRepository bankCardRepository) {
        this.bankCardRepository = bankCardRepository;
    }
}
