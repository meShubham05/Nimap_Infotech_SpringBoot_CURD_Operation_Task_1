package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/all")
    public List<Category> getAllCategories()
    {
        return categoryService.getAllCategories();

        // this method is not mentioned but have created for fetching the Categories
        // fetching all Categories  using the request http://localhost:8080/api/categories/all
    }


    @GetMapping()
    public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page) {
        return categoryService.getAllCategories(page);

        // for fetching the Categories
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category)
    {
        return categoryService.createCategory(category);

        // for creating a new Category
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id)
    {
        return categoryService.getCategoryById(id);

        // for fetching a Category based on the given category id
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        return categoryService.updateCategory(id, categoryDetails);

        // for updating the Category based on the category id
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id)
    {
        categoryService.deleteCategory(id);

        // for deleting the specific category based on the category id
    }
}