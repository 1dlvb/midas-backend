package ru.midas.server.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.midas.server.model.Bakery;
import ru.midas.server.service.BakeryService;

import java.awt.*;
import java.io.Console;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/midas/bakery")
public class BakeryController {

    @NonNull
    private BakeryService service;
    @GetMapping
    public List<Bakery> getAllBakery(){
        return service.fetchBakeryList();
    }

    @PostMapping("save-bakery")
    public Bakery saveBakery(@RequestBody Bakery bakery){
        return service.saveBakery(bakery);
    }

    @GetMapping("/{id}")
    public Bakery findById(@PathVariable Long id){
        return service.findBakeryById(id);
    }

    @PutMapping(value = "update-bakery/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Bakery updateBakery(@RequestBody Bakery bakery, @PathVariable Long id){
        bakery.setId(id);
        return service.updateBakery(bakery);
    }

    @DeleteMapping("delete/{id}")
    public String deleteBakery(@PathVariable Long id){
        return String.format("Id:%d is deleted successfully.", id);
    }
}
