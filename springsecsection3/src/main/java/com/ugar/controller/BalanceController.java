package com.ugar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping(value = "/myBalance")
    public String getBalanceDetails(){
        return  "Here the account details";
    }
}
