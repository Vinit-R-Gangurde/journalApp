package com.example.journalApp.controler;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //it is Specialized vertion of @component which add the funtion in IOC and some more fun
public class healthcare { //the special funtion of @RestController is it will convert its end points into the jason

    @GetMapping("/health-check")
    public String heathCheck(){

        return "ok";
    }
}
