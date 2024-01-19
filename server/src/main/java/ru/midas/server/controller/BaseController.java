package ru.midas.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/midas")
public class BaseController {

    @GetMapping
    public void init(){
        System.out.println("initialization...");
    }
}
