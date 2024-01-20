package ru.midas.server.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.midas.server.model.Category;
import ru.midas.server.repository.CategoryRepository;
import ru.midas.server.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    @NonNull
    private final CategoryRepository repository;
    @Override
    public List<Category> fetchCategoryList() {
        return repository.findAll();
    }

//    @Override
//    public List<Category> findByProductsId(Long productId) {
//        return repository.findByProductsId(productId);
//    }

    @Override
    public Category saveCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public Optional<Category> findCategoryById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Category updateCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}
