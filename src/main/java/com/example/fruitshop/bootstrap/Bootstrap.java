package com.example.fruitshop.bootstrap;

import com.example.fruitshop.model.Category;
import com.example.fruitshop.model.Customer;
import com.example.fruitshop.repository.CategoryRepository;
import com.example.fruitshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Bootstrap implements CommandLineRunner {
    CustomerRepository customerRepository;
    CategoryRepository categoryRepository;
    @Autowired
    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }



    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();
    }

    private void loadCustomers() {
        Customer cust1 = new Customer(1L, "Jan", "Kowalski", "/api/customers/1");
        Customer cust2 = new Customer(2L, "Anna", "Nowak", "/api/customers/2");
        customerRepository.save(cust1);
        customerRepository.save(cust2);
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
