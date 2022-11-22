package com.ugar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
    @GetMapping(value = "/myCards")
    public String getCardsDetails(){
        return  "Here the card details";
    }
}
