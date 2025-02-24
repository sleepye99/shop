package com.example.shop.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//all of the operations are within the range of /categories.
@RequestMapping("/categories")
public class CategoryController {
    //dependency injection of Service class
    @Autowired
    private CategoryService categoryService;

    // GET Method displays all present categories
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
    // POST method here adds a new category
    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }
    //deletes category with respect to its id.
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
    //PUT method updates category.
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }
}
