package com.example.springvito.controllers;

import com.example.springvito.models.Auto;
import com.example.springvito.services.AutosService;

import com.example.springvito.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("springvito/autos")
public class AutosController  {

    private final AutosService autosService;
    private final PersonService personService;

    @GetMapping()
    public String listOfAutos(Model model){
        model.addAttribute("listOfAutos", autosService.findAll());
        return "autos/autos";
    }

    @GetMapping("/add/{id}")
    public String addAuto(@PathVariable("id") int id, @ModelAttribute("auto") Auto auto){
        auto.setOwner(personService.findById(id));
        return "autos/add";
    }

    @PostMapping("/add")
    public String addAuto(@ModelAttribute("auto") Auto auto){
        autosService.saveAuto(auto);
        return "redirect:/springvito/persons/" + auto.getOwner().getId();
    }

    @GetMapping("/edit/{id}")
    public String updateAuto(@PathVariable("id") int id, Model model){
        model.addAttribute("auto", autosService.findById(id));
        return "autos/edit";
    }

    @PatchMapping("/edit/{id}")
    public String editAuto(@PathVariable("id") int id, @ModelAttribute("auto") Auto auto){
        autosService.saveAuto(auto);
        return "redirect:/springvito/persons/" + auto.getOwner().getId();
    }

    @DeleteMapping("/delete/{personId}/{autoId}")
    public String deleteAuto(@PathVariable("personId") int personId, @PathVariable("autoId") int autoId){
        autosService.deleteById(autoId);
        return "redirect:/springvito/persons/" + personId;
    }

}

