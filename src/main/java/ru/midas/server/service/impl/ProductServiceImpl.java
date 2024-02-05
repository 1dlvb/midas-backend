package ru.midas.server.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.midas.server.model.Product;
import ru.midas.server.repository.ProductRepository;
import ru.midas.server.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @NonNull
    private final ProductRepository repository;


    @Override
    public List<Product> fetchProductList() {
        return repository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product findProductById(Long id) {
        return repository.findProductById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {

        repository.delete(this.findProductById(id));
    }
}
