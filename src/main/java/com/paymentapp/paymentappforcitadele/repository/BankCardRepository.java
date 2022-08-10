package com.paymentapp.paymentappforcitadele.repository;

import com.paymentapp.paymentappforcitadele.models.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//in this app collections will be used instead of Data Base
@Repository
public interface BankCardRepository extends JpaRepository<BankCard, Integer> {

}
