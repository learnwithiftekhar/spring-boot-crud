package com.learnwithifte.springBootCrud.service;

import com.learnwithifte.springBootCrud.model.Customer;
import com.learnwithifte.springBootCrud.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
