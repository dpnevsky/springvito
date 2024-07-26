package com.example.springvito.controllers;

import com.example.springvito.models.Person;
import com.example.springvito.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/springvito/registration")
@Controller
@AllArgsConstructor
public class RegistrationController {

    private final PersonService personService;

    @GetMapping ("/log-in")
    public String logIn(){
        return "registration/log-in";
    }

    @GetMapping ("/sign-up")
    public String signUp(@ModelAttribute("person") Person person){
        return "registration/sign-up";
    }

    @PostMapping("/sign-up/register")
    public String register(@ModelAttribute("person") Person person){

        personService.savePerson(person);
        return "redirect:/springvito/registration/log-in";
    }



}
