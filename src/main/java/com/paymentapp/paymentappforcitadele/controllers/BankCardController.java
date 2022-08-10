package com.paymentapp.paymentappforcitadele.controllers;

import com.paymentapp.paymentappforcitadele.models.BankCard;
import com.paymentapp.paymentappforcitadele.models.MonthPicker;
import com.paymentapp.paymentappforcitadele.models.Person;
import com.paymentapp.paymentappforcitadele.models.YearPicker;
import com.paymentapp.paymentappforcitadele.service.BankCardService;
import com.paymentapp.paymentappforcitadele.service.BookService;
import com.paymentapp.paymentappforcitadele.service.EmailSenderService;
import com.paymentapp.paymentappforcitadele.service.PersonService;
import com.paymentapp.paymentappforcitadele.util.BankCardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public BankCardController(BankCardValidator bankCardValidator,PersonService personService, BankCardService bankCardService, EmailSenderService emailSenderService, BookService bookService) {
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


    @GetMapping("/{id}/purchase")
    public String purchase(@ModelAttribute("bankCard") BankCard bankCard, Model model,
                            @PathVariable("id") int id){
        model.addAttribute("book", bookService.findById(id));
        return "/purchase/enteringdata";
    }

    @PostMapping("/{id}/purchase")
    public String performPurchase(@ModelAttribute("bankCard") @Valid BankCard bankCard, BindingResult bindingResult,
                                  Model model, @PathVariable("id") int id, @RequestParam("month") int month,
                                  @RequestParam("year") int year){
        model.addAttribute("book", bookService.findById(id));
        YearMonth yearMonth = YearMonth.of(year, month);
        bankCard.setExpiryDate(LocalDate.of(year, month, yearMonth.lengthOfMonth()));
        bankCardValidator.validate(bankCard, bindingResult);
        if(bindingResult.hasErrors()) return ("/purchase/enteringdata");

        bankCard.getPerson().setBankCard(bankCard);
        bankCard.getPerson().setBook(bookService.findById(id));
        bankCardService.saveBankCard(bankCard);
        Person person = personService.findByBookId(id);


        return "redirect:/mail/" + person.getId();
    }

    @GetMapping("/mail/{id}")
    public String mailSender(@PathVariable("id") int id,Model model){
        Person person = personService.findById(id);
        System.out.println(person.getBankCard().getCardNumber());
        model.addAttribute("person", person);
        emailSenderService.sendEmail(person);
        return "complete";
    }


    @GetMapping("/list/{bookType}")
    public String showListOfBooks(@PathVariable String bookType, Model model) {
        model.addAttribute("bookList",bookService.findByType(bookType));
        model.addAttribute("bookType", bookType);
        return "/list";
    }

}

// Vladislav , Miheenkov , 1234567891234567 , 123, vladjuha13@gmail.com
// name = ForTests surname = TestsProject email = fortestprojects123@gmail.com password = ForTestProjects123

