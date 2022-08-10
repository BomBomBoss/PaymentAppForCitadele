package com.paymentapp.paymentappforcitadele.util;

import com.paymentapp.paymentappforcitadele.models.BankCard;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.LocalDate;

@Component
public class BankCardValidator  implements Validator {

    public static boolean validateCreditCardNumber(String str) {

        int[] ints = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ints[i] = Integer.parseInt(str.substring(i, i + 1));
        }
        for (int i = ints.length - 2; i >= 0; i = i - 2) {
            int j = ints[i];
            j = j * 2;
            if (j > 9) {
                j = j % 10 + 1;
            }
            ints[i] = j;
        }
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
        if (sum % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }

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

        if(!validateCreditCardNumber(bankCard.getCardNumber())){
            errors.rejectValue("cardNumber", "", "Please enter valid card number");
        }


    }
}
