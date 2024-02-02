package ru.midas.server.service;

import ru.midas.server.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> fetchProductList();
    Product saveProduct(Product product);

    Product findProductById(Long id);

    Product updateProduct(Product product);
    void deleteProduct(Long id);
}
