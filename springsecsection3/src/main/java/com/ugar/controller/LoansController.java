package com.ugar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
    @GetMapping(value = "/myLoans")
    public String getLoansDetails(){
        return  "Here the Loans details";
    }
}
