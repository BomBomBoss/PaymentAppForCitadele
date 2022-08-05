package com.paymentapp.paymentappforcitadele.service;

import com.paymentapp.paymentappforcitadele.models.BankCard;
import com.paymentapp.paymentappforcitadele.repository.BankCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankCardService {

    private final BankCardRepository bankCardRepository;
    private int id = 0;

    @Autowired
    public BankCardService(BankCardRepository bankCardRepository) {
        this.bankCardRepository = bankCardRepository;
    }
    public int saveBankCard(BankCard bankCard) {
        bankCardRepository.bankCardMap.put(++id, bankCard);
        return id;
    }

    public void showAll(){
        System.out.println(bankCardRepository.bankCardMap.toString());
    }

    public BankCard findById(int id) {
        return bankCardRepository.bankCardMap.get(id);
    }
}
