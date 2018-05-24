package com.example.fruitshop.service;

import com.example.fruitshop.errors.CustomerNotFoundException;
import com.example.fruitshop.model.Customer;
import com.example.fruitshop.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    CustomerService customerService;

    @Before
    public void setUp() throws Exception {
        customerService = new CustomerService(customerRepository);
    }

    @Test
    public void getAllCustomers() {
        List<Customer> customers = Arrays.asList(new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> allCustomers = customerService.getAllCustomers();

        assertThat(allCustomers.size(),is(2));
    }

    @Test
    public void createCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstname("Jan");
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);


        Customer customerFromDb = customerService.createCustomer(customer);
        assertThat(customerFromDb.getId(), is(1L) );
        assertThat(customerFromDb.getFirstname(), is("Jan"));
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    public void deleteCustomer() {
    }

    @Test
    public void getCustomerById() {
    }

    @Test(expected = CustomerNotFoundException.class)
    public void shouldThrowExceptionWhenUserNotFound(){
        //when repo... to zwracamy null
        //wykonujemy metode na serwisie
    }
}