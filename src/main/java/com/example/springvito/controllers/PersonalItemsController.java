package com.example.springvito.controllers;

import com.example.springvito.models.Auto;
import com.example.springvito.models.PersonalItem;
import com.example.springvito.services.PersonService;
import com.example.springvito.services.PersonalItemsService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("springvito/personal-items")
public class PersonalItemsController  {

    private final PersonalItemsService personalItemsService;
    private final PersonService personService;


    @GetMapping()
    public String listOfPersonalItems(Model model){
        model.addAttribute("listOfPersonalItems", personalItemsService.findAll());
        return "personal-items/personal-items";
    }

    @PostMapping("/add")
    public String addPersonalItem(@ModelAttribute("personalItem")PersonalItem personalItem){
        personalItemsService.saveById(personalItem);
        return "redirect:/springvito/persons/" + personalItem.getOwner().getId();
    }

    @GetMapping("/add/{id}")
    public String addPersonalItem(@PathVariable("id") int id, @ModelAttribute("personalItem") PersonalItem personalItem){
        personalItem.setOwner(personService.findById(id));
        return "personal-items/add";
    }

    @DeleteMapping("/delete/{personId}/{personalItemId}")
    public String deletePersonalItem(@PathVariable("personId") int personId, @PathVariable("personalItemId") int personalItemId){
        personalItemsService.deleteById(personalItemId);
        return "redirect:/springvito/persons/" + personId;
    }

    @GetMapping("/edit/{id}")
    public String updatePersonalItem(@PathVariable("id") int id, Model model){
        model.addAttribute("personalItem", personalItemsService.findById(id));
        return "personal-items/edit";
    }

    @PatchMapping("/edit/{id}")
    public String editAuto(@PathVariable("id") int id, @ModelAttribute("personalItem") PersonalItem personalItem){
        personalItemsService.saveById(personalItem);
        return "redirect:/springvito/persons/" + personalItem.getOwner().getId();
    }
}
