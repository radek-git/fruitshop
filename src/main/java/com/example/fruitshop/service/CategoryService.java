package com.example.fruitshop.service;

import com.example.fruitshop.model.Category;
import com.example.fruitshop.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryService {

    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories (){
        // logika biznesowa
        return categoryRepository.findAll();
    }

    public Category findCategoryByName (String name){
        Category byName = categoryRepository.findByName(name);
        return byName;
    }
}
