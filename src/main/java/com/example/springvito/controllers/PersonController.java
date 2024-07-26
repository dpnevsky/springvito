package com.example.springvito.controllers;

import com.example.springvito.models.Person;
import com.example.springvito.models.Realty;
import com.example.springvito.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("springvito/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/{id}")
    public String showPerson(@PathVariable("id") int id, Model model, @ModelAttribute("realty")Realty realty) {
        Person person = personService.findById(id);
        model.addAttribute("person", person);
        return "persons/show";
    }

    @GetMapping("/list-of-persons")
    public String listOfPersons(Model model){
        model.addAttribute("personsList", personService.findAll());
        return "persons/list-of-persons";
    }

    @GetMapping("/dialog/{realtyId}")
    public String dialog(@PathVariable("realtyId") int realtyId){
        return "persons/dialog";
    }
}
