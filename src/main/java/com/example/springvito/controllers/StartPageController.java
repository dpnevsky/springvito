package com.example.springvito.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/springvito")
@Controller
public class StartPageController {

    @GetMapping()
    public String springVito() {
        return "start-page";
    }

}
