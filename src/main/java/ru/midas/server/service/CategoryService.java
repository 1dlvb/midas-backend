package ru.midas.server.service;


import ru.midas.server.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> fetchCategoryList();
//    List<Category> findByProductsId(Long productId);
    Category saveCategory(Category category);

    Optional<Category> findCategoryById(Long id);

    Category updateCategory(Category category);

    void deleteCategory(Long id);
}
