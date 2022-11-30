package com.ugar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

    @GetMapping(value = "/myNotices")
    public String getNoticesDetails() {
        return "Here the contact details";
    }
}
