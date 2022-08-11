package com.paymentapp.paymentappforcitadele.controllers;

import com.paymentapp.paymentappforcitadele.models.BankCard;
import com.paymentapp.paymentappforcitadele.models.MonthPicker;
import com.paymentapp.paymentappforcitadele.models.Person;
import com.paymentapp.paymentappforcitadele.models.YearPicker;
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
    private final EmailSenderService emailSenderService;
    private final BookService bookService;



    @Autowired
    public BankCardController(BankCardValidator bankCardValidator,PersonService personService, EmailSenderService emailSenderService, BookService bookService) {
        this.bankCardValidator = bankCardValidator;
        this.personService = personService;
        this.emailSenderService = emailSenderService;
        this.bookService = bookService;
    }

    //Creating body for drop down list for the field "Year" on purchase form starting from today and for next 5Y.
    @ModelAttribute("yearPicker")
    public List<YearPicker> pickYear(){
        LocalDate today = LocalDate.now();
        List<YearPicker> list = new ArrayList<>();

        list.add(new YearPicker(today.getYear()));
        list.add(new YearPicker(today.plusYears(1).getYear()));
        list.add(new YearPicker(today.plusYears(2).getYear()));
        list.add(new YearPicker(today.plusYears(3).getYear()));
        list.add(new YearPicker(today.plusYears(4).getYear()));
        list.add(new YearPicker(today.plusYears(5).getYear()));
        return list;
    }

    //Creating body for drop down list for the field "Month" on purchase form. List of 12MO
    @ModelAttribute("monthPicker")
    public List<MonthPicker> pickMonth(){
        List<MonthPicker> list = new ArrayList<>();

        list.addAll(Arrays.asList(new MonthPicker(1), new MonthPicker(2), new MonthPicker(3),
                new MonthPicker(4), new MonthPicker(5), new MonthPicker(6), new MonthPicker(7),
                new MonthPicker(8), new MonthPicker(9), new MonthPicker(10), new MonthPicker(11), new MonthPicker(12)));
        return list;
    }


    //this method receives certain book id according to which one client have chosen from the list. "Id" assigns to int
    //variable and by book id can be found correct book from DB and it's details will be shown above the purchase form
    @GetMapping("/{id}/purchase")
    public String purchase(@ModelAttribute("bankCard") BankCard bankCard, Model model,
                            @PathVariable("id") int id){
        model.addAttribute("book", bookService.findById(id));
        return "/purchase/enteringdata";
    }

    //all entered data by client in purchase form will be assigned to certain object's fields: Bank Card and Person
    //Afterwards Person model will be saved in DB with correctly set book according to book id. Bank Card won't be saved
    // in DB taking into account security policy.
    @PostMapping("/{id}/purchase")
    public String performPurchase(@ModelAttribute("bankCard") @Valid BankCard bankCard, BindingResult bindingResult,
                                  Model model, @PathVariable("id") int id, @RequestParam("month") int month,
                                  @RequestParam("year") int year){
        model.addAttribute("book", bookService.findById(id));
        //bank card's expiry date considers month's latest day so this method calculates certain amount of days in
        // month which should be chosen in "bank card expiry date" drop down list
        YearMonth yearMonth = YearMonth.of(year, month);
        bankCard.setExpiryDate(LocalDate.of(year, month, yearMonth.lengthOfMonth()));
        //Person model is Bank Card field, so using validation for Bank Card it will also validate Person fields
        bankCardValidator.validate(bankCard, bindingResult);
        if(bindingResult.hasErrors()) return ("/purchase/enteringdata");

        String cardNumber = bankCard.getCardNumber();
        bankCard.getPerson().setBook(bookService.findById(id));
        //bank card last 4 digits will be used in mail body and will be taken from Person's field
        bankCard.getPerson().setCardLastFourDigits(cardNumber.substring(cardNumber.length() - 4));
        personService.savePerson(bankCard.getPerson());
        //we retrieve person from DB to use his id as dynamic parameter in mail sending controller
        Person person = personService.findByBookId(id);

        return "redirect:/mail/" + person.getId();
    }

    //this method receives person id to find correct person from DB and use his details in mail body
    @GetMapping("/mail/{id}")
    public String mailSender(@PathVariable("id") int id,Model model){
        Person person = personService.findById(id);
        model.addAttribute("person", person);
        //email will be sent with all needed information from Person's fields
        emailSenderService.sendEmail(person);
        //for security purpose last 4 digits of bank card will be hashed with md5 and updated in DB
        person.setCardLastFourDigits(personService.hashGenerator(person.getCardLastFourDigits()));
        personService.savePerson(person);

        return "complete";
    }


    //this method receives dynamic parameter "bookType" from url to assign it to String variable. Using this parameter
    // we can find correct books in DB and show it to the client
    @GetMapping("/list/{bookType}")
    public String showListOfBooks(@PathVariable String bookType, Model model) {
        model.addAttribute("bookList",bookService.findByType(bookType));
        model.addAttribute("bookType", bookType);
        return "/list";
    }

}


