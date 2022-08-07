package com.paymentapp.paymentappforcitadele.controllers;

import com.paymentapp.paymentappforcitadele.models.BankCard;
import com.paymentapp.paymentappforcitadele.models.MonthPicker;
import com.paymentapp.paymentappforcitadele.models.YearPicker;
import com.paymentapp.paymentappforcitadele.service.BankCardService;
import com.paymentapp.paymentappforcitadele.service.BookService;
import com.paymentapp.paymentappforcitadele.service.EmailSenderService;
import com.paymentapp.paymentappforcitadele.service.PersonService;
import com.paymentapp.paymentappforcitadele.util.BankCardValidator;
import com.paymentapp.paymentappforcitadele.util.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class BankCardController {

    private final BankCardValidator bankCardValidator;
    private final PersonService personService;
    private final BankCardService bankCardService;
    private final EmailSenderService emailSenderService;
    private final BookService bookService;



    @Autowired
    public BankCardController(BankCardValidator bankCardValidator, PersonValidator personValidator, PersonService personService, BankCardService bankCardService, EmailSenderService emailSenderService, BookService bookService) {
        this.bankCardValidator = bankCardValidator;
        this.personService = personService;
        this.bankCardService = bankCardService;
        this.emailSenderService = emailSenderService;
        this.bookService = bookService;
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
        YearMonth yearMonth = YearMonth.of(bankCard.getYear(), bankCard.getMonth());
        bankCard.setExpiryDate(LocalDate.of(bankCard.getYear(), bankCard.getMonth(), yearMonth.lengthOfMonth()));
        bankCardValidator.validate(bankCard, bindingResult);
        if(bindingResult.hasErrors()) return ("/purchase/enteringdata");

        personService.savePerson(bankCard.getPerson());
        int id = bankCardService.saveBankCard(bankCard);

        personService.showAll();
        bankCardService.showAll();
        return "redirect:/mail/" + id;
    }

    @GetMapping("/mail/{id}")
    public String mailSender(@PathVariable int id){
        BankCard bankCard = bankCardService.findById(id);
        String mailTo = bankCard.getPerson().getEmail();
        String subject = "Successful payment";
        String body = "Dear, " + bankCard.getPerson().getName() + ", your payment was performed with card ****" +
                bankCard.getCardNumber().substring(12,16);
        emailSenderService.sendEmail(mailTo,subject,body);
        System.out.println(bankCard);
        return "complete";
    }

    @GetMapping("/list/{id}")
    public String showListOfBooks(@PathVariable String id, Model model) {
        model.addAttribute("bookList",bookService.findByType(id));
        return "/list";
    }

}

// Vladislav , Miheenkov , 1234567891234567 , 123, vladjuha13@gmail.com
// name = ForTests surname = TestsProject email = fortestprojects123@gmail.com password = ForTestProjects123

