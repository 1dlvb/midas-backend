package ru.midas.server.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.midas.server.models.Bakery;

import java.util.List;

@RestController
@RequestMapping("/api/v1/midas")
public class BaseController {

    @GetMapping
    public void init(){
        System.out.println("initialization...");
    }
}
