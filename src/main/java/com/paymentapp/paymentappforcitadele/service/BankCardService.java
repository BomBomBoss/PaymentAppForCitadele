package com.paymentapp.paymentappforcitadele.service;

import com.paymentapp.paymentappforcitadele.models.BankCard;
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
    public void saveBankCard(BankCard bankCard) {
        bankCardRepository.bankCardSet.add(bankCard);
    }

    public void showAll(){
        System.out.println(bankCardRepository.bankCardSet.toString());
    }
}
