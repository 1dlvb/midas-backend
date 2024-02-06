package ru.midas.server.service;


import ru.midas.server.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> fetchCategoryList();
    Category saveCategory(Category category);

    Category findCategoryById(Long id);

    Category updateCategory(Category category);

    void deleteCategory(Long id);
}
