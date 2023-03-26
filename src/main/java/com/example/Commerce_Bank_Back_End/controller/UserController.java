package com.example.Commerce_Bank_Back_End.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Map;


@RestController
public class UserController {

    //
    private final UserDetailsService userDetailsService;

    //
    public UserController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    //
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserNameSimple(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return principal.getName();
    }
}
