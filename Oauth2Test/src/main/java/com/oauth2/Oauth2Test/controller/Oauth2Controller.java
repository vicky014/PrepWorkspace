package com.oauth2.Oauth2Test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Oauth2Controller {

    @GetMapping("/")
    public String home(){
        return "Welcome to my OAuth2 Application";
    }

}
