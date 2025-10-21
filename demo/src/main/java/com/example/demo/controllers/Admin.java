package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
public class Admin {
    @GetMapping("/public")
    public String publicapi(){
        return "this is public ";
    }
    @GetMapping("/private")
    public String privateapi(){
        return "this is private ";
    }



}
