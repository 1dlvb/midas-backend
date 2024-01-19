package ru.midas.server.service;

import ru.midas.server.model.Bakery;

import java.util.List;

public interface BakeryService {
    List<Bakery> fetchBakeryList();
    Bakery saveBakery(Bakery bakery);

    Bakery findBakeryById(Long id);

    Bakery updateBakery(Bakery bakery);
    void deleteBakery(Long id);
}
