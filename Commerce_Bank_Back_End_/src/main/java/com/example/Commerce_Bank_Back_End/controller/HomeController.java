package com.example.Commerce_Bank_Back_End.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    //Retrieve information from front-end.
    //To create a new page, you have to call this get mapping and return here.
    //************************************************************************


    @GetMapping("/home")
    public String home(Principal principal){
        return "Hello, " + principal.getName();
    }

    @GetMapping("/account")
    public String account(Principal principal){
        return "Hello, " + principal.getName();
    }

    @GetMapping("/loanCalculator")
    public String loanCalculator(Principal principal){
        return "Hello, " + principal.getName();
    }



    //Checks to see if person logged in has correct authority
    //************************************************************************

    @PreAuthorize("hasAuthority('SCOPE_read')")
    @GetMapping("/secure")
    public String secure(){return "This is secure!";}
}
