package com.example.fruitshop.bootstrap;

import com.example.fruitshop.model.Category;
import com.example.fruitshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Bootstrap implements CommandLineRunner {

    CategoryRepository categoryRepository;
    @Autowired
    public Bootstrap(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadCategories();
    }

    private void loadCategories() {
        Category c1 = new Category();
        c1.setName("cytrusy");
        c1.setUrl("/api/categories/cytrusy");

        Category c2 = new Category();
        c2.setName("jablka");
        c2.setUrl("/api/categories/jablka");

        categoryRepository.save(c1);
        categoryRepository.save(c2);
    }


}
