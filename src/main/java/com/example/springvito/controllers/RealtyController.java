package com.example.springvito.controllers;

import com.example.springvito.models.Realty;
import com.example.springvito.services.PersonService;
import com.example.springvito.services.RealtyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("springvito/realty")
public class RealtyController  {

    private final RealtyService realtyService;
    private final PersonService personService;

    @GetMapping()
    public String listOfRealty(Model model){
        model.addAttribute("listOfRealty", realtyService.findAll());
//        realtyService.preAuth();
        return "realty/realty";
    }

    @GetMapping("/add/{id}")
    public String addRealty(@PathVariable("id") int id, @ModelAttribute("realty") Realty realty){
        realty.setOwner(personService.findById(id));
        return "realty/add";
    }

    @GetMapping("/edit/{id}")
    public String updateRealty(@PathVariable("id") int id, Model model){
        model.addAttribute("realty", realtyService.findById(id));
        return "realty/edit";
    }

    @PostMapping("/add")
    public String addRealty(@ModelAttribute("realty") Realty realty){
        realtyService.saveRealty(realty);
        return "redirect:/springvito/persons/" + realty.getOwner().getId();
    }

    @DeleteMapping("/delete/{personId}/{realtyId}")
    public String deleteRealty(@PathVariable("realtyId") int realtyId,
                               @PathVariable("personId") int personId){
        realtyService.deleteById(realtyId);
        return "redirect:/springvito/persons/" + personId;
    }

    @PatchMapping("/edit/{id}")
    public String editRealty(@ModelAttribute("realty") Realty realty){
        realtyService.saveRealty(realty);
        return "redirect:/springvito/persons/" + realty.getOwner().getId();
    }
}
