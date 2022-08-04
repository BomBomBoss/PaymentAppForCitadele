package com.paymentapp.paymentappforcitadele.repository;

import com.paymentapp.paymentappforcitadele.models.BankCard;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

//in this app collections will be used instead of Data Base
@Component
public class BankCardRepository {
    Set<BankCard> bankCardSet = new HashSet<>();

    public BankCardRepository() {
    }
}
