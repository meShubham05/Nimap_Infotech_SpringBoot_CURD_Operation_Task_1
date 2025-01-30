package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> getAllCategories()
    {
        return categoryRepository.findAll();
    }
    public Page<Category> getAllCategories(int page)
    {
        return categoryRepository.findAll(PageRequest.of(page, 10));

        // here for Pagination my default size of PageSize is 10  means next element will be added to the next page i.e. to  1st index
    }

    public Category createCategory(Category category)
    {
        return categoryRepository.save(category);

        // saves the Category
    }

    public Optional<Category> getCategoryById(Long id)
    {
        return categoryRepository.findById(id);

        // get Categeory information with the help of id
    }

    public Category updateCategory(Long id, Category categoryDetails)
    {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(categoryDetails.getName());
        return categoryRepository.save(category);

        // update the category by using id
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);

        // delete the category by using id

    }
}