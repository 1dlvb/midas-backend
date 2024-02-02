package ru.midas.server.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.midas.server.model.Cart;
import ru.midas.server.repository.CartRepository;
import ru.midas.server.service.CartService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    @NonNull
    private final CartRepository repository;

    @Override
    public List<Cart> fetchAllCarts() {
        return repository.findAll();
    }

    @Override
    public Cart findCartById(Long id) {
        return repository.findCartById(id);
    }

    @Override
    public Cart saveCart(Cart cart) {
        return repository.save(cart);
    }

    @Override
    public Cart updateCart(Cart cart) {
        return repository.save(cart);
    }

    @Override
    public void deleteCart(Long id) {
        repository.deleteById(id);
    }
}
