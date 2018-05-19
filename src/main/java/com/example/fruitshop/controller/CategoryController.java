package com.example.fruitshop.controller;

import com.example.fruitshop.model.Category;
import com.example.fruitshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping ("/categories")
    public List<Category> categoryList (){
        List<Category> allCategories = categoryService.getAllCategories();
        return allCategories;
    }

    // /api/categories/...

    @GetMapping("/categories/{name}")
    public Category byName (@PathVariable String name){
        return categoryService.findCategoryByName(name);
    }

}
