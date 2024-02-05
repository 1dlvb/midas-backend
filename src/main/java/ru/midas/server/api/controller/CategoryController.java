package ru.midas.server.api.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.midas.server.model.Category;
import ru.midas.server.service.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/midas/category")
public class CategoryController {

    @NonNull
    private CategoryService categoryService;
    @GetMapping()
    public List<Category> getAllCategories(){
        return categoryService.fetchCategoryList();
    }

    @PostMapping("/save")
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id){
        return categoryService.findCategoryById(id);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Category updateCategory(@RequestBody Category category, @PathVariable Long id){
        category.setId(id);
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return String.format("Id:%d is deleted successfully.", id);
    }

}