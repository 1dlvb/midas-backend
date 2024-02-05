package ru.midas.server.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.midas.server.model.Category;
import ru.midas.server.repository.CategoryRepository;
import ru.midas.server.service.CategoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    @NonNull
    private final CategoryRepository repository;
    @Override
    public List<Category> fetchCategoryList() {
        return repository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public Category findCategoryById(Long id) {
        return repository.findCategoryById(id);
    }

    @Override
    public Category updateCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        repository.delete(this.findCategoryById(id));
    }
}
