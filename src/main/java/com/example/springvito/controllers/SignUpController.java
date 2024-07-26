//package com.example.springvito.controllers;
//
//import com.example.springvito.models.Person;
//import com.example.springvito.services.PersonService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/springvito")
//public class SignUpController {
//
//    private PersonService personService;
//
//    @Autowired
//    public SignUpController(PersonService personService) {
//        this.personService = personService;
//    }
//
//    @GetMapping ("/sign-up")
//    public String signUp(@ModelAttribute("person") Person person){
//        return "sign-up";
//    }
//
//    @PostMapping("/sign-up/register")
//    public String register(@ModelAttribute("person") Person person){
//        personService.savePerson(person);
//        return "redirect:/springvito/log-in";
//    }
//
//    @PostMapping("/log-in")
//    public String logIn(){
//        return "redirect:/springvito/persons/";
//    }
//
//
//
//}
