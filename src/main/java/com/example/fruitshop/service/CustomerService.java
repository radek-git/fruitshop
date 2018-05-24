package com.example.fruitshop.service;

import com.example.fruitshop.errors.CustomerNotFoundException;
import com.example.fruitshop.model.Customer;
import com.example.fruitshop.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers (){
        log.info("Getting all customers from db");
        return customerRepository.findAll();
    }

    public Customer createCustomer (Customer customer){
        log.info("Creating customer with data: {}",customer);
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    public void deleteCustomer (Long id){
        log.info("Deleting customer with id: {}", id);
        customerRepository.deleteById(id);
    }

    public Customer getCustomerById (Long id)  {
        log.info("Getting customer with id: {}", id);
        return customerRepository.findById(id)
                .orElseThrow(()-> new CustomerNotFoundException("Nie znaleziono customera o podanym id"));
    }


}
