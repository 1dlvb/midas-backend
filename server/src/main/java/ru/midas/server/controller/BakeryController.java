package ru.midas.server.controllers;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.midas.server.services.BakeryService;

@RestController
@RequestMapping("api/v1/midas/bakery")
@RequiredArgsConstructor
public class BakeryController {

    @NonNull
    private BakeryService service;
}
