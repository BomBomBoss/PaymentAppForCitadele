package com.paymentapp.paymentappforcitadele.repository;

import com.paymentapp.paymentappforcitadele.models.BankCard;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//in this app collections will be used instead of Data Base
@Component
public class BankCardRepository {
    public Map<Integer ,BankCard> bankCardMap = new HashMap<>();

    public BankCardRepository() {
    }
}
