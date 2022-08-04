package com.paymentapp.paymentappforcitadele.util;

import com.paymentapp.paymentappforcitadele.models.BankCard;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.LocalDate;

@Component
public class BankCardValidator  implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return BankCard.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BankCard bankCard = (BankCard) target;

        if(bankCard.getExpiryDate().compareTo(LocalDate.now())<0) {
            errors.rejectValue("expiryDate", "", "Please enter valid expiry date");
        }


    }
}
