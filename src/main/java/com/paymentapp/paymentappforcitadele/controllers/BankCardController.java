package com.paymentapp.paymentappforcitadele.controllers;

import com.paymentapp.paymentappforcitadele.models.BankCard;
import com.paymentapp.paymentappforcitadele.models.MonthPicker;
import com.paymentapp.paymentappforcitadele.models.Person;
import com.paymentapp.paymentappforcitadele.models.YearPicker;
import com.paymentapp.paymentappforcitadele.util.BankCardValidator;
import com.paymentapp.paymentappforcitadele.util.PersonValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class BankCardController {

    private final BankCardValidator bankCardValidator;
    protected final PersonValidator personValidator;

    public BankCardController(BankCardValidator bankCardValidator, PersonValidator personValidator) {
        this.bankCardValidator = bankCardValidator;
        this.personValidator = personValidator;
    }

    @ModelAttribute("yearPicker")
    public List<YearPicker> pickYear(){
        LocalDate today = LocalDate.now();
        List<YearPicker> list = new ArrayList<>();

        list.add(new YearPicker(today.getYear()));
        list.add(new YearPicker(today.plusYears(1).getYear()));
        list.add(new YearPicker(today.plusYears(2).getYear()));
        list.add(new YearPicker(today.plusYears(3).getYear()));
        list.add(new YearPicker(today.plusYears(4).getYear()));
        return list;
    }

    @ModelAttribute("monthPicker")
    public List<MonthPicker> pickMonth(){
        List<MonthPicker> list = new ArrayList<>();

        list.addAll(Arrays.asList(new MonthPicker(1), new MonthPicker(2), new MonthPicker(3),
                new MonthPicker(4), new MonthPicker(5), new MonthPicker(6), new MonthPicker(7),
                new MonthPicker(8), new MonthPicker(9), new MonthPicker(10), new MonthPicker(11), new MonthPicker(12)));
        return list;
    }


    @GetMapping("/purchase")
    public String purchase(@ModelAttribute("bankCard") BankCard bankCard){
        return "/purchase/enteringdata";
    }

    @PostMapping("/purchase")
    public String performPurchase(@ModelAttribute @Valid BankCard bankCard, BindingResult bindingResult){
        bankCard.setExpiryDate(LocalDate.of(bankCard.getYear(), bankCard.getMonth(),1));
        bankCardValidator.validate(bankCard, bindingResult);
        if(bindingResult.hasErrors()) return ("/purchase/enteringdata");
        return "/purchase/complete";

    }
}
