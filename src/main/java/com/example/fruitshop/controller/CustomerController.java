package com.example.fruitshop.controller;


import com.example.fruitshop.model.Customer;
import com.example.fruitshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> customerList (){
        return customerService.getAllCustomers();

    }

    @PostMapping(path="/customers", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer (@RequestBody Customer customer){
        customerService.createCustomer(customer);
        //TODO zrobic przypadek gdy taki customer istmnieje -> CONFLICT
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomerById (@PathVariable Long id){
        customerService.deleteCustomer(id);
        //TODO zrobić przypadek gdy customer o pdanym id nie istnieje i zwrócić kod błędu

    }

    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer customerById (@PathVariable Long id){
        return customerService.getCustomerById(id);
    }
}
