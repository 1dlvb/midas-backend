package ru.midas.server.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.midas.server.model.Bakery;
import ru.midas.server.repository.BakeryRepository;
import ru.midas.server.service.BakeryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BakeryServiceImpl implements BakeryService {

    @NonNull
    private final BakeryRepository repository;

    @Override
    public List<Bakery> fetchBakeryList() {
        return repository.findAll();
    }
    @Override
    public Bakery saveBakery(Bakery bakery) {
        return repository.save(bakery);
    }

    @Override
    public Bakery findBakeryById(Long id) {
        return repository.findBakeryById(id);
    }

    @Override
    public Bakery updateBakery(Bakery bakery) {
        return repository.save(bakery);
    }

    @Override
    public void deleteBakery(Long id) {
        repository.deleteById(id);
    }
}
