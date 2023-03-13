package com.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

// just a controller to confirm server is up and reachable
@Controller
@RequestMapping("/health") // uri for this controller endpoint
public class HealthController {
    @Autowired
    public HealthController(){
        System.out.println("Health Controller initialized.");
    }

    // doesn't work without explicit ResponseBody for me, just include it from now on
    @GetMapping(value = "/ping")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String ping() {
        System.out.println("Ping hit");
        return "{\"thing\": \"pong!\"}";
    }
}
