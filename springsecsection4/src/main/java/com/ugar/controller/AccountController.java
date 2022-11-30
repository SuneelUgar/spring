package com.ugar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping(value = "/myAccount")
    public String getAccountDetails(){
        return  "Here the account details";
    }
}
