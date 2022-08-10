package com.paymentapp.paymentappforcitadele.service;

import com.paymentapp.paymentappforcitadele.models.BankCard;
import com.paymentapp.paymentappforcitadele.repository.BankCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BankCardService {

    private final BankCardRepository bankCardRepository;

    @Autowired
    public BankCardService(BankCardRepository bankCardRepository) {
        this.bankCardRepository = bankCardRepository;
    }
    public void saveBankCard(BankCard bankCard) {
        bankCardRepository.save(bankCard);
    }

    public BankCard findById(int id) {
        Optional<BankCard> bankCard = bankCardRepository.findById(id);
        return bankCard.orElse(null);
    }

    public List<BankCard> showAll(){
        return bankCardRepository.findAll();
    }

}
