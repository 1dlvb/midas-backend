package ru.midas.server.service;


import ru.midas.server.model.Cart;

import java.util.List;

public interface CartService {
    List<Cart> fetchAllCarts();
    Cart findCartById(Long id);
    Cart saveCart(Cart cart);
    Cart updateCart(Cart cart);
    void deleteCart(Long id);
}
