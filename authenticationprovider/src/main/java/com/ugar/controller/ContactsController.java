package com.ugar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactsController {

    @GetMapping(value = "/myContacts")
    public String getContactsDetails(){
        return  "Here the contact details";
    }
}
